package com.nocountry.nocountry.config.mapper;

import com.nocountry.nocountry.dto.request.RoleRequestDTO;
import com.nocountry.nocountry.dto.response.RoleResponseDTO;
import com.nocountry.nocountry.models.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    @Mapping(source = "roleName", target = "roleName")
    @Mapping(source = "roleDescription", target = "roleDescription")
    RoleResponseDTO toRoleResponseDTO(Role role);

    @Mapping(source = "roleName", target = "roleName")
    @Mapping(source = "roleDescription", target = "roleDescription")
    Role toRole(RoleRequestDTO dto);
}
