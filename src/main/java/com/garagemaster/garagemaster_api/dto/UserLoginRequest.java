package com.garagemaster.garagemaster_api.dto;

import lombok.Data;

@Data
public class UserLoginRequest {
    private String username;
    private String password;
}