package com.nocountry.nocountry.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class TeamRequestDTO {
    @NotNull(message = "El nombre del equipo es obligatorio.")
    private String teamName;

    @NotNull(message = "El nombre del proyecto es obligatorio.")
    private String projectName;

    private List<UUID> teamFrameworks;

    private List<UUID> technologies;

    private String meetUrl;

    private String whatsappUrl;

    @NotNull(message = "El ID del líder de equipo es obligatorio.")
    private UUID tl;

    private List<UUID> participants;
}
