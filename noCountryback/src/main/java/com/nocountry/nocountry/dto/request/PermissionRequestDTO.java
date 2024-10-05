package com.nocountry.nocountry.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PermissionRequestDTO {
    @NotBlank(message = "El nombre del permiso es obligatorio.")
    String permissionName;
}
