package com.example.jpainvestigation.data.repo;

import com.example.jpainvestigation.data.entity.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Integer> {
}