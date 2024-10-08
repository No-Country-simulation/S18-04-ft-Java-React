package com.nocountry.nocountry.dto.request;

import com.nocountry.nocountry.dto.response.EventRecordResponseDTO;
import com.nocountry.nocountry.models.enums.EventType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class EventRequestDTO {
    @NotNull(message = "El tipo de evento es obligatorio.")
    private EventType eventType;
    @NotBlank(message = "El nombre del evento es obligatorio.")
    @Size(max = 100, message = "El nombre del evento debe tener menos de 100 caracteres.")
    private String eventName;
    @Size(max = 500, message = "La descripción del evento debe tener menos de 500 caracteres.")
    private String eventDescription;
    @NotNull(message = "El número de participantes es obligatorio.")
    @Min(value = 1, message = "El número de participantes debe ser al menos 1.")
    private Integer eventParticipant;
    @NotNull(message = "La fecha de inicio del evento es obligatoria.")
    private LocalDate eventDateStart;
    @NotNull(message = "La fecha de fin del evento es obligatoria.")
    private LocalDate eventDateEnd;
    private List<EventRecordResponseDTO> eventRecords;
}
