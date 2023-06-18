package com.example.jpainvestigation.data.repo;

import com.example.jpainvestigation.data.entity.FilmCategory;
import com.example.jpainvestigation.data.entity.FilmCategoryId;
import org.springframework.data.repository.CrudRepository;

public interface FilmCategoryRepository extends CrudRepository<FilmCategory, FilmCategoryId> {
}