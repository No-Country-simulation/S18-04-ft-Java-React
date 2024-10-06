package com.nocountry.nocountry.config.mapper;

import com.nocountry.nocountry.dto.request.FrameworkRequestDTO;
import com.nocountry.nocountry.dto.response.FrameworkResponseDTO;
import com.nocountry.nocountry.models.Framework;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface FrameworkMapper {

    FrameworkMapper INSTANCE = Mappers.getMapper(FrameworkMapper.class);

    Framework toFramework(FrameworkRequestDTO dto);

    FrameworkResponseDTO toFrameworkDTO(Framework framework);
}