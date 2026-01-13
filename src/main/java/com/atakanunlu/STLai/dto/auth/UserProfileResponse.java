package com.atakanunlu.STLai.dto.auth;

public record UserProfileResponse(
        Long id,
        String email,
        String name,
        String avatarUrl
) {
}
