package com.atakanunlu.STLai.dto.auth;

public record LoginRequest(
        String email,
        String password
) {
}
