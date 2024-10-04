package com.nocountry.nocountry.dto.request;

import com.nocountry.nocountry.dto.response.SessionResponseDTO;
import com.nocountry.nocountry.dto.response.SurveyResponseDTO;
import com.nocountry.nocountry.dto.response.TeamResponseDTO;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class ParticipantRequestDTO {
    private Boolean isTl;
    @NotNull(message = "El equipo es obligatorio.")
    private TeamResponseDTO team;
    private List<SurveyResponseDTO> participants;
    private List<SurveyResponseDTO> buddy;
    private  List<SessionResponseDTO>sessions;
}
