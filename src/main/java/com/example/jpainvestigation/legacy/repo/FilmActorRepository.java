package com.example.jpainvestigation.legacy.repo;

import com.example.jpainvestigation.legacy.entity.FilmActor;
import com.example.jpainvestigation.legacy.entity.FilmActorId;
import org.springframework.data.repository.CrudRepository;

public interface FilmActorRepository extends CrudRepository<FilmActor, FilmActorId> {
}