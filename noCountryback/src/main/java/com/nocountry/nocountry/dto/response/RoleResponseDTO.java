package com.nocountry.nocountry.dto.response;

import java.util.List;
import java.util.UUID;

public record RoleResponseDTO(
        UUID id,
        String roleName,
        String roleDescription
) {
}
