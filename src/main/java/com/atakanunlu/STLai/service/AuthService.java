package com.atakanunlu.STLai.service;

import com.atakanunlu.STLai.dto.auth.AuthResponse;
import com.atakanunlu.STLai.dto.auth.LoginRequest;
import com.atakanunlu.STLai.dto.auth.SignupRequest;
import org.jspecify.annotations.Nullable;

public interface AuthService {

    AuthResponse signup(SignupRequest request);

    AuthResponse login(LoginRequest request);

}
