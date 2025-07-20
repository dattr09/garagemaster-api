package com.garagemaster.garagemaster_api.service.impl;

import com.garagemaster.garagemaster_api.model.Customer;
import com.garagemaster.garagemaster_api.repository.CustomerRepository;
import com.garagemaster.garagemaster_api.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getById(String id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer update(String id, Customer customer) {
        customer.setId(id);
        return customerRepository.save(customer);
    }

    @Override
    public void delete(String id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<Customer> searchByName(String name) {
        return customerRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public Customer getByEmail(String email) {
        return customerRepository.findByEmail(email);
    }
}
