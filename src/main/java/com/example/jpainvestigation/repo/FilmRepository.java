package com.example.jpainvestigation.repo;

import com.example.jpainvestigation.entity.Film;
import org.springframework.data.repository.CrudRepository;

public interface FilmRepository extends CrudRepository<Film, Integer> {
}