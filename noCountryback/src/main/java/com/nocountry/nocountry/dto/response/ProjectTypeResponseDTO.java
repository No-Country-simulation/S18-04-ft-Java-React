package com.nocountry.nocountry.dto.response;

import java.util.UUID;

public record ProjectTypeResponseDTO(
        UUID id,
        String projectTypeName,
        String projectTypeDescription
) {
}
