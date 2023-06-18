package com.example.jpainvestigation.legacy.repo;

import com.example.jpainvestigation.legacy.entity.FilmCategory;
import com.example.jpainvestigation.legacy.entity.FilmCategoryId;
import org.springframework.data.repository.CrudRepository;

public interface FilmCategoryRepository extends CrudRepository<FilmCategory, FilmCategoryId> {
}