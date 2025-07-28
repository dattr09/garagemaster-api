package com.garagemaster.garagemaster_api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.garagemaster.garagemaster_api.dto.*;
import com.garagemaster.garagemaster_api.service.*;
import com.garagemaster.garagemaster_api.model.User;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserRegisterRequest request) {
        System.out.println("Request nhận được: " + request);
        try {
            userService.register(request);
            System.out.println("Đăng ký thành công!");
            return ResponseEntity.ok("User registered successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Đăng ký thất bại: " + e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginRequest request) {
        String token = userService.login(request);
        User user = userService.findByEmail(request.getEmail());
        if (user == null) {
            return ResponseEntity.badRequest().body("Invalid email or password");
        }
        Map<String, Object> simpleUser = new HashMap<>();
        simpleUser.put("id", user.getId());
        simpleUser.put("email", user.getEmail());
        simpleUser.put("roles", user.getRoles());

        Map<String, Object> response = new HashMap<>();
        response.put("token", token);
        response.put("user", simpleUser);
        response.put("message", "Đăng nhập thành công!");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword(@RequestBody ForgotPasswordRequest request) {
        userService.sendResetCode(request.getEmail());
        return ResponseEntity.ok("Reset code sent to email");
    }

    @PostMapping("/confirm-email")
    public ResponseEntity<String> confirmEmail(@RequestBody ConfirmEmailRequest request) {
        boolean valid = userService.verifyResetCode(request.getEmail(), request.getCode());
        return valid ? ResponseEntity.ok("Code valid") : ResponseEntity.badRequest().body("Invalid code");
    }

    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@RequestBody ResetPasswordRequest request) {
        boolean success = userService.resetPassword(request.getEmail(), request.getCode(), request.getNewPassword());
        return success ? ResponseEntity.ok("Password reset successful")
                : ResponseEntity.badRequest().body("Reset failed");
    }
}
