package com.garagemaster.garagemaster_api.service;

import java.util.List;

import com.garagemaster.garagemaster_api.dto.CreateEmployeeRequest;
import com.garagemaster.garagemaster_api.model.Employee;

public interface EmployeeService {
    List<Employee> getAll();
    Employee getById(String id);
    Employee getByUserId(String userId);

    // Sửa tại đây 👇
    Employee create(CreateEmployeeRequest request);

    Employee update(String id, Employee employee);
    void delete(String id);
    List<Employee> searchByName(String name);
}
