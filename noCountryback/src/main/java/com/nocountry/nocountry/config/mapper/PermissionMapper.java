package com.nocountry.nocountry.config.mapper;

import com.nocountry.nocountry.dto.request.PermissionResponseDTO;
import com.nocountry.nocountry.models.PPermission;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PermissionMapper {

    PermissionMapper INSTANCE = Mappers.getMapper(PermissionMapper.class);

    @Mapping(source = "permissionName", target = "permissionName")
    PermissionResponseDTO toPermissionResponseDTO(PPermission permission);

    @Mapping(source = "permissionName", target = "permissionName")
    PPermission toPPermission(PermissionResponseDTO dto);
}
