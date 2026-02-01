package com.atakanunlu.STLai.service.impl;

import com.atakanunlu.STLai.dto.project.ProjectRequest;
import com.atakanunlu.STLai.dto.project.ProjectResponse;
import com.atakanunlu.STLai.dto.project.ProjectSummaryResponse;
import com.atakanunlu.STLai.entity.Project;
import com.atakanunlu.STLai.entity.ProjectMember;
import com.atakanunlu.STLai.entity.ProjectMemberId;
import com.atakanunlu.STLai.entity.User;
import com.atakanunlu.STLai.enums.ProjectRole;
import com.atakanunlu.STLai.error.ResourceNotFoundException;
import com.atakanunlu.STLai.mapper.ProjectMapper;
import com.atakanunlu.STLai.repository.ProjectMemberRepository;
import com.atakanunlu.STLai.repository.ProjectRepository;
import com.atakanunlu.STLai.repository.UserRepository;
import com.atakanunlu.STLai.service.ProjectService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
@Transactional
public class ProjectServiceImpl implements ProjectService {

    ProjectRepository projectRepository;
    UserRepository userRepository;
    ProjectMapper projectMapper;
    ProjectMemberRepository projectMemberRepository;

    @Override
    public ProjectResponse createProject(ProjectRequest request, Long userId) {

        User owner = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", userId.toString()));

        Project project = Project.builder()
                .name(request.name())
                .isPublic(false)
                .build();


        project = projectRepository.save(project);

        ProjectMemberId projectMemberId = new ProjectMemberId(project.getId(), owner.getId());
        ProjectMember projectMember = ProjectMember.builder()
                .id(projectMemberId)
                .projectRole(ProjectRole.OWNER)
                .user(owner)
                .acceptedAt(Instant.now())
                .invitedAt(Instant.now())
                .project(project)
                .build();

        projectMemberRepository.save(projectMember);

        return projectMapper.toProjectResponse(project);

    }


    @Override
    public List<ProjectSummaryResponse> getUserProjects(Long userId) {
//        return projectRepository.findAllAccessibleByUser(userId)
//                .stream()
//                .map(projectMapper::toProjectSummaryResponse)
//                .toList();

        var projects = projectRepository.findAllAccessibleByUser(userId);
        return projectMapper.toListOfProjectSummaryResponse(projects);
    }

    @Override
    public ProjectResponse getUserProjectById(Long id, Long userId) {

        Project project = getAccessibleProjectById(id,userId);

        return projectMapper.toProjectResponse(project);
    }



    @Override
    public ProjectResponse updateProject(Long id, ProjectRequest request, Long userId) {

        Project project = getAccessibleProjectById(id,userId);



        project.setName(request.name());
        projectRepository.save(project);

        return projectMapper.toProjectResponse(project);

    }

    @Override
    public void softDelete(Long id, Long userId) {

        Project project = getAccessibleProjectById(id,userId);


        project.setDeletedAt(Instant.now());
        projectRepository.save(project);

    }

    //INTERNAL FONKSIYON
    public Project getAccessibleProjectById(Long projectId, Long userId){
        return projectRepository.findAccessibleProjectById(projectId,userId)
                .orElseThrow(() -> new ResourceNotFoundException("Project", projectId.toString()));
    }

}
