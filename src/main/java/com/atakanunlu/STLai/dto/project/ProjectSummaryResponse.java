package com.atakanunlu.STLai.dto.project;

import com.atakanunlu.STLai.dto.auth.UserProfileResponse;

import java.time.Instant;

public record ProjectSummaryResponse(
        Long id,
        String projectName,
        Instant createdAt,
        Instant updatedAt,
        UserProfileResponse owner
) {
}
