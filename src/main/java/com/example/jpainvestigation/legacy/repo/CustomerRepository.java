package com.example.jpainvestigation.legacy.repo;

import com.example.jpainvestigation.legacy.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    List<Customer> findByFirstNameAndEmail(String firstName, String email);
    
    @Query("SELECT c FROM Customer c WHERE c.firstName = :firstName OR c.email = :email")
    List<Customer> findByFirstNameOrEmail(String firstName, String email);

    @Query("SELECT c FROM Customer c WHERE (:firstName is null or c.firstName = :firstName) OR (:email is null or c.email = :email)")
    List<Customer> findByLikeFirstNameOrEmail(String firstName, String email);
}
