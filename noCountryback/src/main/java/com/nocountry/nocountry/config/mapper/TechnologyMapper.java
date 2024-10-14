package com.nocountry.nocountry.config.mapper;

import com.nocountry.nocountry.dto.request.TechnologyRequestDTO;
import com.nocountry.nocountry.dto.response.TechnologyResponseDTO;
import com.nocountry.nocountry.models.Technology;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TechnologyMapper {

    TechnologyMapper INSTANCE = Mappers.getMapper(TechnologyMapper.class);

    TechnologyResponseDTO toTechnologyResponseDTO(Technology technology);

    Technology toTechnology(TechnologyRequestDTO dto);
}
