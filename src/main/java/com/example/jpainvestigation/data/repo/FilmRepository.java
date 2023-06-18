package com.example.jpainvestigation.data.repo;

import com.example.jpainvestigation.data.entity.Film;
import org.springframework.data.repository.CrudRepository;

public interface FilmRepository extends CrudRepository<Film, Integer> {
}