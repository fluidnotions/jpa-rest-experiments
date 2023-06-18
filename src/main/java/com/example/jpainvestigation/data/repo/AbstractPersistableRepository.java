package com.example.jpainvestigation.data.repo;

import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface AbstractPersistableRepository<T extends AbstractPersistable, ID> extends CrudRepository<T, ID> {
}