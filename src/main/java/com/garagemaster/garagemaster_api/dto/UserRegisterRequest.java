package com.garagemaster.garagemaster_api.dto;

import lombok.Data;

@Data
public class UserRegisterRequest {
    private String username;
    private String password;
    private String comfirmPassword;
    private String email;

}