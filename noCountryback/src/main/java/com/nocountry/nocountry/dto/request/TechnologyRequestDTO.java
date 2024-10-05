package com.nocountry.nocountry.dto.request;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public class TechnologyRequestDTO {
    @NotNull(message = "El nombre de la tecnología es obligatorio.")
    private String technologyName;

    @NotNull(message = "Los tipos de tecnología son obligatorios.")
    private List<String> technologyTypes;
}
