package com.example.jpainvestigation.repo;

import com.example.jpainvestigation.entity.Inventory;
import org.springframework.data.repository.CrudRepository;


public interface InventoryRepository extends CrudRepository<Inventory, Integer> {
}