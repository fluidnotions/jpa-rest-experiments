package com.example.jpainvestigation.data.repo;

import com.example.jpainvestigation.data.entity.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
}