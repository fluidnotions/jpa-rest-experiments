package com.example.jpainvestigation.search;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.apache.commons.lang3.NotImplementedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;


@RestController
public class SearchGenericCriteriaController {


    record Search(Where where, Optional<Projection> projection) {
        public void validate() {
            if (projection.isPresent()) {
                throw new NotImplementedException("Projection is not implemented");
            }
        }
    }


    record Where(Optional<Map<String, String>> eq,
                 Optional<Map<String, String>> like,
                 Optional<Map<String, String>> notLike,
                 Optional<Map<String, String>> in,
                 Optional<Map<String, String>> notIn) {
        public void validate() {
            List<Optional<Map<String, String>>> options = List.of(like, notLike, in, notIn);
            for (Optional<Map<String, String>> option : options) {
                if (option.isPresent()) {
                    throw new NotImplementedException("Option is not implemented: " + option.toString());
                }
            }
        }
    }

    record Projection(Optional<Map<String, String>> include, Optional<Map<String, String>> exclude) {
    }

    private static final Logger logger = LoggerFactory.getLogger(SearchGenericCriteriaController.class);

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private ObjectMapper objectMapper;

    @PutMapping(value = "/search/{entity}", produces = "application/json", consumes = "application/json")
    public String search(@PathVariable String entity, @RequestBody Search search) throws JsonProcessingException {
        var entities = entityManager
                .getMetamodel()
                .getEntities();
        var entityNames = entities.stream().map(e -> e.getName().toLowerCase()).collect(Collectors.joining(", "));
        logger.info("Entities: {}", entityNames);
        var entityType = entities.stream()
                .filter(e -> e.getName().toLowerCase().equals(entity.toLowerCase()))
                .findFirst()
                .orElse(null);
        logger.info("Entity: {}", entityType);
        if (entityType != null) {
            var results = searchEntities(entityType.getJavaType(), entityManager, search);
            var javaTypeList = TypeFactory.defaultInstance().constructCollectionType(List.class, entityType.getJavaType());
            var writer = objectMapper.writerFor(javaTypeList);
            var json = writer.writeValueAsString(results);
            return json;
        } else {
            return null;
        }
    }

    private List<?> searchEntities(Class<?> domainClass, EntityManager entityManager, Search search) {

        search.validate();
        search.where().validate();

        if (search.where().eq().isEmpty()) {
            throw new IllegalStateException("search.where().eq() is empty, this is currently not supported since other conditionals have not been implemented yet.");
        }

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<?> criteriaQuery = criteriaBuilder.createQuery(domainClass);
        Root<?> root = criteriaQuery.from(domainClass);

        List<Predicate> predicates = new ArrayList<>();
        Field[] fields = domainClass.getDeclaredFields();
        for (var entry : search.where().eq().get().entrySet()) {
            Arrays.stream(fields)
                    .filter(f -> f.getName().equals(entry.getKey()))
                    .findFirst()
                    .ifPresent(f -> {
                        f.setAccessible(true);
                        var rootName = root.get(f.getName());
                        var value = entry.getValue();
                        predicates.add(criteriaBuilder.equal(rootName, value));
                    });
        }
        criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()]));
        var query = entityManager.createQuery(criteriaQuery);
        var results = query.getResultList();
        return results;
    }
}
