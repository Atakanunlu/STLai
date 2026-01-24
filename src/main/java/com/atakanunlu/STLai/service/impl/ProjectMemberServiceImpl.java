package com.atakanunlu.STLai.service.impl;

import com.atakanunlu.STLai.dto.member.InviteMemberRequest;
import com.atakanunlu.STLai.dto.member.MemberResponse;
import com.atakanunlu.STLai.dto.member.UpdateMemberRequest;
import com.atakanunlu.STLai.entity.Project;
import com.atakanunlu.STLai.entity.ProjectMember;
import com.atakanunlu.STLai.entity.ProjectMemberId;
import com.atakanunlu.STLai.entity.User;
import com.atakanunlu.STLai.mapper.ProjectMemberMapper;
import com.atakanunlu.STLai.repository.ProjectMemberRepository;
import com.atakanunlu.STLai.repository.ProjectRepository;
import com.atakanunlu.STLai.repository.UserRepository;
import com.atakanunlu.STLai.service.ProjectMemberService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Transactional
public class ProjectMemberServiceImpl implements ProjectMemberService {

    ProjectMemberRepository projectMemberRepository;
    ProjectRepository projectRepository;
    ProjectMemberMapper projectMemberMapper;
    UserRepository userRepository;


    @Override
    public List<MemberResponse> getProjectMembers(Long projectId, Long userId) {

        Project project = getAccessibleProjectById(projectId,userId);

        List<MemberResponse> memberResponseList = new ArrayList<>();
        memberResponseList.add(projectMemberMapper.toProjectMemberResponseFromOwner(project.getOwner()));

        memberResponseList.addAll(
                projectMemberRepository.findByIdProjectId(projectId)
                        .stream().map(projectMemberMapper::toProjectMemberResponseFromMember)
                        .toList()
        );

        return memberResponseList;
    }

    @Override
    public MemberResponse inviteMember(Long projectId, InviteMemberRequest request, Long userId) {
        Project project = getAccessibleProjectById(projectId,userId);

        if (!project.getOwner().getId().equals(userId)){
            throw new RuntimeException("İzin yok");
        }

        User invitee = userRepository.findByEmail(request.email()).orElseThrow();

        if (invitee.getId().equals(userId)){
            throw new RuntimeException("Kendine davet atamazsın");
        }

        ProjectMemberId projectMemberId = new ProjectMemberId(projectId,invitee.getId());
        if (projectMemberRepository.existsById(projectMemberId)){
            throw new RuntimeException("Davet edilen kişiye davet gönderilmiş");
        }

        ProjectMember member = ProjectMember
                .builder()
                .id(projectMemberId)
                .user(invitee)
                .projectRole(request.role())
                .invitedAt(Instant.now())
                .project(project)
                .build();
        projectMemberRepository.save(member);

        return projectMemberMapper.toProjectMemberResponseFromMember(member);
    }

    @Override
    public MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRequest request, Long userId) {

        Project project = getAccessibleProjectById(projectId,userId);

        if (!project.getOwner().getId().equals(userId)){
            throw new RuntimeException("İzin yok");
        }


        ProjectMemberId projectMemberId = new ProjectMemberId(projectId,memberId);
        ProjectMember projectMember = projectMemberRepository.findById(projectMemberId).orElseThrow();

        if (projectMember.getProjectRole().equals(request.role())){
            throw new RuntimeException("Secilen role ile aynı rol secildi. "+projectMember.getProjectRole());
        }

        projectMember.setProjectRole(request.role());
        projectMemberRepository.save(projectMember);

        return projectMemberMapper.toProjectMemberResponseFromMember(projectMember);
    }

    @Override
    public void removeProjectMember(Long projectId, Long memberId, Long userId) {

        Project project = getAccessibleProjectById(projectId,userId);
        if (!project.getOwner().getId().equals(userId)){
            throw new RuntimeException("İzin yok");
        }

        ProjectMemberId projectMemberId = new ProjectMemberId(projectId,memberId);
        if (!projectMemberRepository.existsById(projectMemberId)){
            throw new RuntimeException(" Projede istenilen kişi bulunamadı.");
        }

        projectMemberRepository.deleteById(projectMemberId);

    }

    //INTERNAL FONKSIYON
    public Project getAccessibleProjectById(Long projectId, Long userId){
        return projectRepository.findAccessibleProjectById(projectId,userId).orElseThrow();
    }

}
