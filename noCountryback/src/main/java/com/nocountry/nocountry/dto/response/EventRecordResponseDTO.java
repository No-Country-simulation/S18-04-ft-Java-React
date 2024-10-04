package com.nocountry.nocountry.dto.response;

import com.nocountry.nocountry.models.*;
import com.nocountry.nocountry.models.enums.Schedule;

import java.util.List;
import java.util.UUID;

public record EventRecordResponseDTO(
        UUID id,
        Schedule schedule,
        Boolean tl,
        RoleType roleType,
        List<FrameworkResponseDTO> stack,
        LanguagesResponseDTO language,
        ProfileResponseDTO profile,
        EventResponseDTO event
) {
}
