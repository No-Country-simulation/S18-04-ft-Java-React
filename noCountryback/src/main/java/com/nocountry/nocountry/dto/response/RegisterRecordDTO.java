package com.nocountry.nocountry.dto.response;

import com.nocountry.nocountry.models.Languages;
import com.nocountry.nocountry.models.enums.Schedule;

import java.util.List;

public record RegisterRecordDTO(
        List<RoleTypeResponseDTO> roles,
        List<LanguagesResponseDTO> languages,
        List<String>schedules,
        List<FrameworkResponseDTO> frameworks
) {
}
