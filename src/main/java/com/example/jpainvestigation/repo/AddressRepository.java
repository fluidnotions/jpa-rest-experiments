package com.example.jpainvestigation.repo;

import com.example.jpainvestigation.entity.Address;
import org.springframework.data.repository.CrudRepository;


public interface AddressRepository extends CrudRepository<Address, Integer> {
}