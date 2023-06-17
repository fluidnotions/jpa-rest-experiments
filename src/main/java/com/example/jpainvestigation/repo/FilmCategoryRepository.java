package com.example.jpainvestigation.repo;

import com.example.jpainvestigation.entity.FilmCategory;
import com.example.jpainvestigation.entity.FilmCategoryId;
import org.springframework.data.repository.CrudRepository;


public interface FilmCategoryRepository extends CrudRepository<FilmCategory, FilmCategoryId> {
}