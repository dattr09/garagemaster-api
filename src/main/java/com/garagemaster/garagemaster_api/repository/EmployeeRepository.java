package com.garagemaster.garagemaster_api.repository;

import com.garagemaster.garagemaster_api.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
    Optional<Employee> findByUserId(String userId);
    List<Employee> findByNameContainingIgnoreCase(String name);
}
