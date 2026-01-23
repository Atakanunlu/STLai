package com.atakanunlu.STLai.service;

import com.atakanunlu.STLai.dto.auth.AuthResponse;
import com.atakanunlu.STLai.dto.auth.LoginRequest;
import com.atakanunlu.STLai.dto.auth.SignupRequest;


public interface AuthService {

    AuthResponse signup(SignupRequest request);

    AuthResponse login(LoginRequest request);

}
