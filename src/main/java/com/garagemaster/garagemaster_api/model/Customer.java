package com.garagemaster.garagemaster_api.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "customers")
public class Customer {
    @Id
    private String id;
    private String userId;
    private String name;
    private String email;
    private String phone;
    private String address;
    private LocalDateTime createdAt = LocalDateTime.now();
}
