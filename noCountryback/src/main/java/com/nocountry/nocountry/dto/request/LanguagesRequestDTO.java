package com.nocountry.nocountry.dto.request;

import com.nocountry.nocountry.dto.response.EventRecordResponseDTO;
import lombok.Data;

import java.util.List;

@Data
public class LanguagesRequestDTO {
    private String languageName;
    private List<EventRecordResponseDTO> eventRecords;
}
