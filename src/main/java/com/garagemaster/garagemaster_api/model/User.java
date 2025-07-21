package com.garagemaster.garagemaster_api.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String username;
    private String email;
    private String password; // đổi từ passwordHash sang password
    private List<String> roles; // đổi từ role sang roles
    private boolean emailConfirmed = false;
    private String emailConfirmationCode;
    private LocalDateTime emailConfirmationCodeExpiry;
}