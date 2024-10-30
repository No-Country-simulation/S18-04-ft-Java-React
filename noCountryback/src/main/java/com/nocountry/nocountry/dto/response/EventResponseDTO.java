package com.nocountry.nocountry.dto.response;

import com.nocountry.nocountry.models.enums.EventType;
import com.nocountry.nocountry.models.enums.State;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record EventResponseDTO(
    UUID id,
    EventType eventType,
    String eventName,
    String eventDescription,
    Integer eventParticipant,
    LocalDate eventDateStart,
    LocalDate eventDateEnd,
    State state
) { }
