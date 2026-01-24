package com.atakanunlu.STLai.service;

import com.atakanunlu.STLai.dto.member.InviteMemberRequest;
import com.atakanunlu.STLai.dto.member.MemberResponse;
import com.atakanunlu.STLai.dto.member.UpdateMemberRequest;

import java.util.List;

public interface ProjectMemberService {
     List<MemberResponse> getProjectMembers(Long projectId, Long userId);

     MemberResponse inviteMember(Long projectId, InviteMemberRequest request, Long userId);

     MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRequest request, Long userId);

     void removeProjectMember(Long projectId, Long memberId, Long userId);
}
