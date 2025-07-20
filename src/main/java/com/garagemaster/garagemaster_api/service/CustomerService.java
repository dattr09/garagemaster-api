package com.garagemaster.garagemaster_api.service;

import com.garagemaster.garagemaster_api.model.Customer;
import java.util.List;

public interface CustomerService {
    List<Customer> getAll();
    Customer getById(String id);
    Customer create(Customer customer);
    Customer update(String id, Customer customer);
    void delete(String id);
    List<Customer> searchByName(String name);
    Customer getByEmail(String email);
}
