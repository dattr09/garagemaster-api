package com.garagemaster.garagemaster_api.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.garagemaster.garagemaster_api.dto.CreateEmployeeRequest;
import com.garagemaster.garagemaster_api.model.Employee;
import com.garagemaster.garagemaster_api.model.EmployeeRole;
import com.garagemaster.garagemaster_api.model.User;
import com.garagemaster.garagemaster_api.repository.EmployeeRepository;
import com.garagemaster.garagemaster_api.repository.UserRepository;
import com.garagemaster.garagemaster_api.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

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
    public Employee create(CreateEmployeeRequest request) {
        // Kiểm tra email đã tồn tại
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email đã tồn tại trong hệ thống");
        }

        // 1. Tạo User mới
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRoles(List.of(request.getEmployeeRole())); // VD: "Admin", "Manager"
        user.setEmailConfirmed(true); // Cho nhân viên mặc định là đã xác thực
        user = userRepository.save(user);

        // 2. Tạo Employee mới
        Employee employee = new Employee();
        employee.setName(request.getName());
        employee.setPhone(request.getPhone());
        employee.setAddress(request.getAddress());
        employee.setEmployeeRole(EmployeeRole.valueOf(request.getEmployeeRole()));
        employee.setUserId(user.getId());
        employee.setDateJoined(LocalDateTime.now());

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
