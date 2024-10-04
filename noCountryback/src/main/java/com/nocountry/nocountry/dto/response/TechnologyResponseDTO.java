package com.nocountry.nocountry.dto.response;

import com.nocountry.nocountry.models.enums.TechnologyType;

import java.util.List;
import java.util.UUID;

public record TechnologyResponseDTO(
        UUID id,
        String technologyName,
        List<TechnologyType> technologyTypes
) {
}
