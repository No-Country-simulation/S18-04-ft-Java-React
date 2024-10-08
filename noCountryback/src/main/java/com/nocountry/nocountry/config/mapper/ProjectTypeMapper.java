package com.nocountry.nocountry.config.mapper;

import com.nocountry.nocountry.dto.request.ProjectTypeRequestDTO;
import com.nocountry.nocountry.dto.response.ProjectTypeResponseDTO;
import com.nocountry.nocountry.models.ProjectType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProjectTypeMapper {

    ProjectTypeMapper INSTANCE = Mappers.getMapper(ProjectTypeMapper.class);

    @Mapping(source = "projectTypeName", target = "projectTypeName")
    @Mapping(source = "projectTypeDescription", target = "projectTypeDescription")
    ProjectTypeResponseDTO toProjectTypeResponseDTO(ProjectType projectType);

    @Mapping(source = "projectTypeName", target = "projectTypeName")
    @Mapping(source = "projectTypeDescription", target = "projectTypeDescription")
    ProjectType toProjectType(ProjectTypeRequestDTO dto);
}
