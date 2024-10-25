package com.nocountry.nocountry.dto.request;

import com.nocountry.nocountry.dto.response.EventResponseDTO;
import com.nocountry.nocountry.dto.response.FrameworkResponseDTO;
import com.nocountry.nocountry.dto.response.LanguagesResponseDTO;
import com.nocountry.nocountry.dto.response.ProfileResponseDTO;
import com.nocountry.nocountry.models.RoleType;
import com.nocountry.nocountry.models.enums.Schedule;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class EventRecordRequestDTO {
    @NotNull(message = "El horario es obligatorio")
    private Schedule schedule; // Disponibilidad Horaria
    private Boolean tl; // Si es Team Leader
    @NotNull(message = "El tipo de rol es obligatorio")
    private RoleType roleType; // roleType:{ "roleTypeId":"djad-gfa-d-ga-d-ad-a"}
    @NotNull(message = "La stack de tecnologías es obligatoria.")
    @Size(min = 1, message = "La stack de tecnologías debe contener al menos un elemento.")
    private List<FrameworkResponseDTO> stack; // "stack":[{"frameworkId":""}]
    @NotNull(message = "El language es obligatorio")
    private LanguagesResponseDTO language; // "language":{"languageId":"sadad-ada-d-d"}
    @NotNull(message = "El perfil es obligatorio")
    private ProfileResponseDTO profile; // ""
    @NotNull(message = "El evento es obligatorio")
    private EventResponseDTO event; // "event":{"eventId":"adda-dd-ad-as-da"}
}
