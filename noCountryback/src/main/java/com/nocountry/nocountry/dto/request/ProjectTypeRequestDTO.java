package com.nocountry.nocountry.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProjectTypeRequestDTO {
    @NotBlank(message = "El nombre del tipo de proyecto es obligatorio.")
    @Size(max = 100, message = "El nombre del tipo de proyecto no debe exceder los 100 caracteres.")
    private String projectTypeName;
    @NotBlank(message = "La descripción del tipo de proyecto es obligatoria.")
    @Size(max = 255, message = "La descripción del tipo de proyecto no debe exceder los 255 caracteres.")
    private String projectTypeDescription;
}
