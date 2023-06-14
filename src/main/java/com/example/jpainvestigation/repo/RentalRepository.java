package com.example.jpainvestigation.repo;

import com.example.jpainvestigation.entity.Rental;
import org.springframework.data.repository.CrudRepository;

public interface RentalRepository extends CrudRepository<Rental, Integer> {
}