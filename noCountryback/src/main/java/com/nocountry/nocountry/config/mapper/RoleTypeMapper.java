package com.nocountry.nocountry.config.mapper;

import com.nocountry.nocountry.dto.request.RoleTypeRequestDTO;
import com.nocountry.nocountry.dto.response.RoleTypeResponseDTO;
import com.nocountry.nocountry.models.RoleType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RoleTypeMapper {

    RoleTypeMapper INSTANCE = Mappers.getMapper(RoleTypeMapper.class);

    @Mapping(source = "roleTypeName", target = "roleTypeName")
    RoleTypeResponseDTO toRoleTypeResponseDTO(RoleType roleType);

    @Mapping(source = "roleTypeName", target = "roleTypeName")
    @Mapping(source = "projectTypeId", target = "projectType.id")
    RoleType toRoleType(RoleTypeRequestDTO dto);
}
