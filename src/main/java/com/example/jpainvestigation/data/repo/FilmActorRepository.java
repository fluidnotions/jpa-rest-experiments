package com.example.jpainvestigation.data.repo;

import com.example.jpainvestigation.data.entity.FilmActor;
import com.example.jpainvestigation.data.entity.FilmActorId;
import org.springframework.data.repository.CrudRepository;

public interface FilmActorRepository extends CrudRepository<FilmActor, FilmActorId> {
}