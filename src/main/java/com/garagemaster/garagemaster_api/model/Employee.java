package com.garagemaster.garagemaster_api.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "employees")
public class Employee {
    @Id
    private String id;
    private String userId;
    private String name;
    private String phone;
    private String address;
    private EmployeeRole employeeRole = EmployeeRole.Employee;
    private LocalDateTime dateJoined = LocalDateTime.now();
}
