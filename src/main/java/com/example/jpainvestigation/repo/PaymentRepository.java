package com.example.jpainvestigation.repo;

import com.example.jpainvestigation.entity.Payment;
import org.springframework.data.repository.CrudRepository;


public interface PaymentRepository extends CrudRepository<Payment, Integer> {
}