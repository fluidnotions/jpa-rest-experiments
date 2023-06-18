package com.example.jpainvestigation.data.repo;

import com.example.jpainvestigation.data.entity.Country;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, Integer> {
}