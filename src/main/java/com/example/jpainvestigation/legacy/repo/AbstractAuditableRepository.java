package com.example.jpainvestigation.legacy.repo;

import org.springframework.data.jpa.domain.AbstractAuditable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface AbstractAuditableRepository<T extends AbstractAuditable, ID> extends CrudRepository<T, ID> {
}