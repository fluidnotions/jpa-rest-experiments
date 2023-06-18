package com.example.jpainvestigation.data.repo;

import com.example.jpainvestigation.data.entity.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Integer> {
}