package com.example.jpainvestigation.legacy.repo;

import com.example.jpainvestigation.legacy.entity.Inventory;
import org.springframework.data.repository.CrudRepository;

public interface InventoryRepository extends CrudRepository<Inventory, Integer> {
}