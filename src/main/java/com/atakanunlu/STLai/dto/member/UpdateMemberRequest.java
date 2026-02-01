package com.atakanunlu.STLai.dto.member;

import com.atakanunlu.STLai.enums.ProjectRole;
import jakarta.validation.constraints.NotBlank;

public record UpdateMemberRequest(
        @NotBlank ProjectRole role
) {
}
