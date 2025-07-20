package com.garagemaster.garagemaster_api.service.impl;

import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.garagemaster.garagemaster_api.dto.*;
import com.garagemaster.garagemaster_api.model.User;
import com.garagemaster.garagemaster_api.repository.*;
import com.garagemaster.garagemaster_api.service.JwtService;
import com.garagemaster.garagemaster_api.service.UserService;


import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public void register(UserRegisterRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRoles(List.of("Customer")); // default role
        userRepository.save(user);
    }

    @Override
    public String login(UserLoginRequest request) {
        // DÒNG QUAN TRỌNG NHẤT
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()
            )
        );

        // Nếu không bị lỗi, tức là xác thực thành công → tạo JWT
        User user = userRepository.findByUsername(request.getUsername())
            .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return jwtService.generateToken(user.getUsername());
    }
}

    
