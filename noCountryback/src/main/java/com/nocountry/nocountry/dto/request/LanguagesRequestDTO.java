package com.nocountry.nocountry.dto.request;

import com.nocountry.nocountry.dto.response.EventRecordResponseDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class LanguagesRequestDTO {
    @NotBlank(message = "El nombre del lenguaje es obligatorio.")
    @Size(max = 50, message = "El nombre del lenguaje no debe exceder los 50 caracteres.")
    private String languageName;
    private List<EventRecordResponseDTO> eventRecords;
}
