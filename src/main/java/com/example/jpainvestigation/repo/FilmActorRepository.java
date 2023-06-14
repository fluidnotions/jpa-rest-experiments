package com.example.jpainvestigation.repo;

import com.example.jpainvestigation.entity.FilmActor;
import com.example.jpainvestigation.entity.FilmActorId;
import org.springframework.data.repository.CrudRepository;

public interface FilmActorRepository extends CrudRepository<FilmActor, FilmActorId> {
}