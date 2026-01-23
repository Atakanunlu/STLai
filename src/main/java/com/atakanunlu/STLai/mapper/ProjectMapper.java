package com.atakanunlu.STLai.mapper;

import com.atakanunlu.STLai.dto.project.ProjectResponse;
import com.atakanunlu.STLai.dto.project.ProjectSummaryResponse;
import com.atakanunlu.STLai.entity.Project;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    ProjectResponse toProjectResponse(Project project);

    @Mapping(target = "projectName",source = "name")
    ProjectSummaryResponse toProjectSummaryResponse(Project project);

    List<ProjectSummaryResponse> toListOfProjectSummaryResponse(List<Project> projects);

}
