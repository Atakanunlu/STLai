package com.atakanunlu.STLai.service;

import com.atakanunlu.STLai.dto.member.InviteMemberRequest;
import com.atakanunlu.STLai.dto.member.MemberResponse;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface ProjectMemberService {
     List<MemberResponse> getProjectMembers(Long projectId, Long userId);

     MemberResponse inviteMember(Long projectId, InviteMemberRequest request, Long userId);

     MemberResponse updateMemberRole(Long projectId, Long memberId, InviteMemberRequest request, Long userId);

     MemberResponse deleteProjectMember(Long projectId, Long memberId, Long userId);
}
