package com.atakanunlu.STLai.service.impl;

import com.atakanunlu.STLai.dto.auth.AuthResponse;
import com.atakanunlu.STLai.dto.auth.LoginRequest;
import com.atakanunlu.STLai.dto.auth.SignupRequest;
import com.atakanunlu.STLai.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServeImpl implements AuthService {
    @Override
    public AuthResponse signup(SignupRequest request) {
        return null;
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        return null;
    }
}
