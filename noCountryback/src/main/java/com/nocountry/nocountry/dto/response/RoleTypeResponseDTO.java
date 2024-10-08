package com.nocountry.nocountry.dto.response;

import java.util.UUID;

public record RoleTypeResponseDTO(
        UUID id,
        String roleTypeName
) {
}
