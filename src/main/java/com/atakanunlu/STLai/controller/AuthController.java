package com.atakanunlu.STLai.controller;

import com.atakanunlu.STLai.dto.auth.AuthResponse;
import com.atakanunlu.STLai.dto.auth.LoginRequest;
import com.atakanunlu.STLai.dto.auth.SignupRequest;
import com.atakanunlu.STLai.dto.auth.UserProfileResponse;
import com.atakanunlu.STLai.service.AuthService;
import com.atakanunlu.STLai.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
public class AuthController {

     UserService userService;
     AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signup(@RequestBody SignupRequest request){
        return ResponseEntity.ok(authService.signup(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request){
        return ResponseEntity.ok(authService.login(request));
    }

    @GetMapping("/me")
    public ResponseEntity<UserProfileResponse> getProfile() {
        Long userId = 1L; //DUMMY simdilik

        return ResponseEntity.ok(userService.getProfile(userId));

    }
}
