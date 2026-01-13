package com.atakanunlu.STLai.controller;

import com.atakanunlu.STLai.dto.auth.AuthResponse;
import com.atakanunlu.STLai.dto.auth.LoginRequest;
import com.atakanunlu.STLai.dto.auth.SignupRequest;
import com.atakanunlu.STLai.dto.auth.UserProfileResponse;
import com.atakanunlu.STLai.service.AuthService;
import com.atakanunlu.STLai.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService authService;
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signup(SignupRequest request){
        return ResponseEntity.ok(authService.signup(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(LoginRequest request){
        return ResponseEntity.ok(authService.login(request));
    }

    @GetMapping("/me")
    public ResponseEntity<UserProfileResponse> getProfile() {
        Long userId = 1L; //DUMMY simdilik

        return ResponseEntity.ok(userService.getProfile(userId));

    }
}
