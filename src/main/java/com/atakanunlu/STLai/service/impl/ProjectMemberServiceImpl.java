package com.atakanunlu.STLai.service.impl;

import com.atakanunlu.STLai.dto.member.InviteMemberRequest;
import com.atakanunlu.STLai.dto.member.MemberResponse;
import com.atakanunlu.STLai.dto.member.UpdateMemberRequest;
import com.atakanunlu.STLai.service.ProjectMemberService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectMemberServiceImpl implements ProjectMemberService {

    @Override
    public List<MemberResponse> getProjectMembers(Long projectId, Long userId) {
        return List.of();
    }

    @Override
    public MemberResponse inviteMember(Long projectId, InviteMemberRequest request, Long userId) {
        return null;
    }

    @Override
    public MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRequest request, Long userId) {
        return null;
    }

    @Override
    public MemberResponse deleteProjectMember(Long projectId, Long memberId, Long userId) {
        return null;
    }
}
