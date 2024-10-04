package com.nocountry.nocountry.dto.request;

import com.nocountry.nocountry.dto.response.EventResponseDTO;
import com.nocountry.nocountry.dto.response.FrameworkResponseDTO;
import com.nocountry.nocountry.dto.response.LanguagesResponseDTO;
import com.nocountry.nocountry.dto.response.ProfileResponseDTO;
import com.nocountry.nocountry.models.RoleType;
import com.nocountry.nocountry.models.enums.Schedule;
import lombok.Data;

import java.util.List;

@Data
public class EventRecordRequestDTO {
    private Schedule schedule;
    private Boolean tl;
    private RoleType roleType;
    private List<FrameworkResponseDTO> stack;
    private LanguagesResponseDTO language;
    private ProfileResponseDTO profile;
    private EventResponseDTO event;
}
