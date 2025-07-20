package com.garagemaster.garagemaster_api.service;

import com.garagemaster.garagemaster_api.model.Employee;
import java.util.List;

public interface EmployeeService {
    List<Employee> getAll();
    Employee getById(String id);
    Employee getByUserId(String userId);
    Employee create(Employee employee);
    Employee update(String id, Employee employee);
    void delete(String id);
    List<Employee> searchByName(String name);
}
