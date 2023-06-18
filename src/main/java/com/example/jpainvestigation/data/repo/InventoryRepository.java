package com.example.jpainvestigation.data.repo;

import com.example.jpainvestigation.data.entity.Inventory;
import org.springframework.data.repository.CrudRepository;

public interface InventoryRepository extends CrudRepository<Inventory, Integer> {
}