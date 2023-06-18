package com.example.jpainvestigation.data.repo;

import com.example.jpainvestigation.data.entity.Rental;
import org.springframework.data.repository.CrudRepository;

public interface RentalRepository extends CrudRepository<Rental, Integer> {
}