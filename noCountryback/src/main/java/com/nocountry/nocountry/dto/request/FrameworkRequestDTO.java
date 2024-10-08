package com.nocountry.nocountry.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class FrameworkRequestDTO {
    @NotBlank(message = "El nombre del framework es obligatorio.")
    @Size(max = 100, message = "El nombre del framework no debe exceder los 100 caracteres.")
    private String frameworkName;
}
