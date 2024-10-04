package com.nocountry.nocountry.dto.response;

import java.util.UUID;

public record SurveyResponseDTO(
        UUID id,
        Double teamWork,
        Double communication,
        Double proactivity,
        Double positiveAttitude,
        Double toleranceToChange,
        Double adaptability,
        Double troubleshooting
) {
}
