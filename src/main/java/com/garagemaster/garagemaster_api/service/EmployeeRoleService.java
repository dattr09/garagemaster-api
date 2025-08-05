package com.garagemaster.garagemaster_api.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class EmployeeRoleService {
    private static final Map<String, String> ROLE_DESCRIPTIONS = Map.of(
        "ADMIN", "Quản trị viên",
        "MANAGER", "Quản lý",
        "STAFF", "Nhân viên"
    );

    public List<String> getAllRoles() {
        return List.of("ADMIN", "MANAGER", "STAFF");
    }

    public boolean isValidRole(String role) {
        return getAllRoles().contains(role);
    }

    public String getDefaultRole() {
        return "STAFF";
    }

    public String getRoleDescription(String role) {
        return ROLE_DESCRIPTIONS.getOrDefault(role, "Không xác định");
    }
}
