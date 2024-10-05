package com.nocountry.nocountry.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class SessionRequestDTO {
    @NotNull(message = "La fecha de la sesión es obligatoria.")
    private LocalDate sessionDate;

    @NotNull(message = "El estado es obligatorio.")
    private Boolean sessionPresent;

    private String sessionObservable;

    @NotNull(message = "El ID del participante es obligatorio.")
    private UUID participantId;
}
