package com.garagemaster.garagemaster_api.dto;

import lombok.Data;

@Data
public class ConfirmEmailRequest {
    private String email;
    private String code;
}
