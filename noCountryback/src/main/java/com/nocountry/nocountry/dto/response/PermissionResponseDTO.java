package com.nocountry.nocountry.dto.response;

import java.util.UUID;

public record PermissionResponseDTO(
        UUID id,
        String permissionName
) {
}
