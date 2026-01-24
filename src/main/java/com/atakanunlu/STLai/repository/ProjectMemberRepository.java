package com.atakanunlu.STLai.repository;

import com.atakanunlu.STLai.entity.ProjectMember;
import com.atakanunlu.STLai.entity.ProjectMemberId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectMemberRepository extends JpaRepository<ProjectMember, ProjectMemberId> {

    List<ProjectMember> findByIdProjectId(Long projectId);

}
