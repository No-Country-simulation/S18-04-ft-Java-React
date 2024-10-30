package com.nocountry.nocountry.dto.request;

import com.nocountry.nocountry.dto.response.EventRecordResponseDTO;
import com.nocountry.nocountry.models.Framework;
import com.nocountry.nocountry.models.Technology;
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

    private List<Framework> teamFrameworks;

    private List<Technology> technologies;

    private String meetUrl;

    private String whatsappUrl;

    @NotNull(message = "El ID del líder de equipo es obligatorio.")
    private UUID tl;

    private List<EventRecordResponseDTO> participants;
}
