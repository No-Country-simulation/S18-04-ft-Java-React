package com.nocountry.nocountry.dto.response;

import java.time.LocalDate;
import java.util.UUID;

public record SessionResponseDTO(
        UUID id,
        LocalDate sessionDate,
        Boolean sessionPresent,
        String sessionObservable,
        String participantName,
        String participantLastname,
        String  teamName
) {
}
