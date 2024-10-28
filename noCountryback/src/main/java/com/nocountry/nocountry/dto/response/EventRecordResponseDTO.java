package com.nocountry.nocountry.dto.response;

import com.nocountry.nocountry.models.*;
import com.nocountry.nocountry.models.enums.Schedule;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record EventRecordResponseDTO(
        UUID id,
        Schedule schedule,
        Boolean tl,
        RoleTypeResponseDTO roleType,
        List<FrameworkResponseDTO> stack,
        UUID languageId,
        String languageName,
        UUID profileId,
        String profileName,
        String profileLastname,
        String eventId,
        String eventName,
        String eventDescription,
        LocalDate eventDateStart,
        LocalDate eventDateEnd
        ) {
}
