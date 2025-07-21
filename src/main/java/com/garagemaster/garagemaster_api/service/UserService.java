package com.garagemaster.garagemaster_api.service;

import com.garagemaster.garagemaster_api.dto.*;

public interface UserService {
    void register(UserRegisterRequest request);
    String login(UserLoginRequest request);
    void sendResetCode(String email);
    boolean verifyResetCode(String email, String code);
    boolean resetPassword(String email, String code, String newPassword);
}