package com.nocountry.nocountry.dto.response;

import com.nocountry.nocountry.models.Participant;

import java.time.LocalDate;
import java.util.UUID;

public record SessionResponseDTO(
        UUID id,
        LocalDate sessionDate,
        Boolean sessionPresent,
        String sessionObservable,
        ParticipantResponseDTO participant
) {
}
