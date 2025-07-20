package com.garagemaster.garagemaster_api.service.impl;

import com.garagemaster.garagemaster_api.model.Employee;
import com.garagemaster.garagemaster_api.repository.EmployeeRepository;
import com.garagemaster.garagemaster_api.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getById(String id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Employee getByUserId(String userId) {
        return employeeRepository.findByUserId(userId).orElse(null);
    }

    @Override
    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee update(String id, Employee employee) {
        employee.setId(id);
        return employeeRepository.save(employee);
    }

    @Override
    public void delete(String id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> searchByName(String name) {
        return employeeRepository.findByNameContainingIgnoreCase(name);
    }
}
