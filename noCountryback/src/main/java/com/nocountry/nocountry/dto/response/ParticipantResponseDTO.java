package com.nocountry.nocountry.dto.response;

import com.nocountry.nocountry.models.Session;
import com.nocountry.nocountry.models.Survey;
import com.nocountry.nocountry.models.Team;

import java.util.List;
import java.util.UUID;

public record ParticipantResponseDTO(
        UUID id,
        Boolean isTl,
        TeamResponseDTO team,
        List<SurveyResponseDTO> participants,
        List<SurveyResponseDTO> buddy,
        List<SessionResponseDTO>sessions
) {
}
