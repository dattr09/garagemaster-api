package com.garagemaster.garagemaster_api.service.impl;

import com.garagemaster.garagemaster_api.dto.*;
import com.garagemaster.garagemaster_api.model.User;
import com.garagemaster.garagemaster_api.repository.UserRepository;
import com.garagemaster.garagemaster_api.security.JwtUtil;
import com.garagemaster.garagemaster_api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.SimpleMailMessage;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final JavaMailSender mailSender;

    // Lưu mã xác thực tạm thời (có thể thay bằng Redis hoặc DB)
    private final ConcurrentHashMap<String, String> resetCodes = new ConcurrentHashMap<>();

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
            .orElseThrow(() -> new RuntimeException("User not found"));

        return jwtUtil.generateToken(user.getUsername(), user.getRoles());
    }

    @Override
    public void sendResetCode(String email) {
        String code = String.format("%06d", new Random().nextInt(999999));
        resetCodes.put(email, code);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Mã xác thực GarageMaster");
        message.setText("Mã xác thực của bạn là: " + code);
        mailSender.send(message);
    }

    @Override
    public boolean verifyResetCode(String email, String code) {
        return code.equals(resetCodes.get(email));
    }

    @Override
    public boolean resetPassword(String email, String code, String newPassword) {
        if (!verifyResetCode(email, code)) return false;
        User user = userRepository.findByEmail(email).orElse(null);
        if (user == null) return false;
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
        resetCodes.remove(email);
        return true;
    }
}


