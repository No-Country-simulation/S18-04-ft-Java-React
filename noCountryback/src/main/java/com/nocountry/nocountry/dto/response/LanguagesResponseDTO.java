package com.nocountry.nocountry.dto.response;

import com.nocountry.nocountry.models.EventRecord;

import java.util.List;
import java.util.UUID;

public record LanguagesResponseDTO(
        UUID id,
        String languageName
) {
}
