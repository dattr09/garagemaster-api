package com.garagemaster.garagemaster_api.dto;


import lombok.Data;

@Data
public class CreateEmployeeRequest {
    private String name;
    private String phone;
    private String address;
    private String email;
    private String password;
    private String employeeRole;
}
