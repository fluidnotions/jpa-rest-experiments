package com.example.jpainvestigation.criteria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@NoRepositoryBean
public abstract class GenericCriteriaRepository<T, ID> extends SimpleJpaRepository<T, ID> {

   @PersistenceContext
   private EntityManager entityManager;

   public GenericCriteriaRepository(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
      super(entityInformation, entityManager);
   }

   public List<T> searchEntities(T entity) {
      CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
      CriteriaQuery<T> criteriaQuery = (CriteriaQuery<T>) criteriaBuilder.createQuery(entity.getClass());
      Root<T> root = (Root<T>) criteriaQuery.from(entity.getClass());

      List<Predicate> predicates = new ArrayList<>();

      Field[] fields = entity.getClass().getDeclaredFields();
      for (Field field : fields) {
         field.setAccessible(true);
         try {
            Object value = field.get(entity);
            if (value != null) {
               predicates.add(criteriaBuilder.equal(root.get(field.getName()), value));
            }
         } catch (IllegalAccessException e) {
            e.printStackTrace();
         }
      }

      criteriaQuery.where(predicates.toArray(new Predicate[0]));

      return entityManager.createQuery(criteriaQuery).getResultList();
   }
}
