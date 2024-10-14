package com.nocountry.nocountry.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class SurveyRequestDTO {
    @NotNull(message = "El trabajo en equipo es obligatorio.")
    private Double teamWork;

    @NotNull(message = "La comunicación es obligatoria.")
    private Double communication;

    @NotNull(message = "La proactividad es obligatoria.")
    private Double proactivity;

    @NotNull(message = "La actitud positiva es obligatoria.")
    private Double positiveAttitude;

    @NotNull(message = "La tolerancia al cambio es obligatoria.")
    private Double toleranceToChange;

    @NotNull(message = "La adaptabilidad es obligatoria.")
    private Double adaptability;

    @NotNull(message = "La resolución de problemas es obligatoria.")
    private Double troubleshooting;

    @NotNull(message = "El ID del participante es obligatorio.")
    private UUID participantId;

    @NotNull(message = "El ID del compañero es obligatorio.")
    private UUID buddyId;
}
