package com.nocountry.nocountry.dto.response;

import java.util.List;
import java.util.UUID;

public record TeamResponseDTO(
        UUID id,
        String teamName,
        String projectName,
        List<FrameworkResponseDTO> teamFrameworks,
        List<TechnologyResponseDTO>technologies,
        String meetUrl,
        String whatsappUrl,
        ParticipantResponseDTO tl,
        List<ParticipantResponseDTO>participants
) {
}
