package com.garagemaster.garagemaster_api.controller;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.garagemaster.garagemaster_api.dto.*;
import com.garagemaster.garagemaster_api.service.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserRegisterRequest request) {
        userService.register(request);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody UserLoginRequest request) {
        String token = userService.login(request);
        return ResponseEntity.ok(new AuthResponse(token));
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
        return success ? ResponseEntity.ok("Password reset successful") : ResponseEntity.badRequest().body("Reset failed");
    }
}

