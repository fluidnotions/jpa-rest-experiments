package com.example.jpainvestigation.legacy.repo;

import com.example.jpainvestigation.legacy.entity.Country;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, Integer> {
}