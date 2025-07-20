package com.garagemaster.garagemaster_api.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "employees")
public class Employee {
    @Id
    private String id;
    private String userId; // Liên kết với User
    private String name;
    private String phone;
    private String address;
    private String employeeRole; // "Admin" hoặc "Employee"
    private LocalDateTime dateJoined;
}
