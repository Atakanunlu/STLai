package com.atakanunlu.STLai.dto.member;

import com.atakanunlu.STLai.enums.ProjectRole;

public record UpdateMemberRequest(
        ProjectRole role
) {
}
