package com.atakanunlu.STLai.dto.auth;

public record AuthResponse(
        String token,
        UserProfileResponse user
) {
}
