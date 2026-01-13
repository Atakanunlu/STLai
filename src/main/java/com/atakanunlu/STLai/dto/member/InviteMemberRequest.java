package com.atakanunlu.STLai.dto.member;

import com.atakanunlu.STLai.enums.ProjectRole;

public record InviteMemberRequest(
        String email,
        ProjectRole role

) {
}
