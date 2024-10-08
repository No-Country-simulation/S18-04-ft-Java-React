package com.nocountry.nocountry.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RoleRequestDTO {
    @NotBlank(message = "El nombre del rol es obligatorio.")
    @Size(max = 50, message = "El nombre del rol no debe exceder los 50 caracteres.")
    private String roleName;
    @Size(max = 255, message = "La descripción del rol no debe exceder los 255 caracteres.")
    private String roleDescription;
}
