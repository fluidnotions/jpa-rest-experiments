package com.example.jpainvestigation.legacy.repo;

import com.example.jpainvestigation.legacy.entity.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Integer> {
}