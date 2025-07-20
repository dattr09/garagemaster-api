package com.garagemaster.garagemaster_api.repository;

import com.garagemaster.garagemaster_api.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer, String> {
    List<Customer> findByNameContainingIgnoreCase(String name);
    Customer findByEmail(String email);
}
