package com.example.jpainvestigation.repo;

import com.example.jpainvestigation.entity.Country;
import org.springframework.data.repository.CrudRepository;


public interface CountryRepository extends CrudRepository<Country, Integer> {
}