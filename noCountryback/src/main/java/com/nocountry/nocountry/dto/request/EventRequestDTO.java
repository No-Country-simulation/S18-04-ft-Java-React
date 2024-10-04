package com.nocountry.nocountry.dto.request;

import com.nocountry.nocountry.dto.response.EventRecordResponseDTO;
import com.nocountry.nocountry.models.enums.EventType;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class EventRequestDTO {
    private EventType eventType;
    private String eventName;
    private String eventDescription;
    private Integer eventParticipant;
    private LocalDate eventDateStart;
    private LocalDate eventDateEnd;
    private List<EventRecordResponseDTO> eventRecords;
}
