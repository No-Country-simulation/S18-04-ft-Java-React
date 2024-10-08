package com.nocountry.nocountry.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.UUID;

@Data
public class RoleTypeRequestDTO {
    @NotBlank(message = "El nombre del tipo de rol es obligatorio.")
    @Size(max = 50, message = "El nombre del tipo de rol no debe exceder los 50 caracteres.")
    private String roleTypeName;
    private UUID projectTypeId;
}
