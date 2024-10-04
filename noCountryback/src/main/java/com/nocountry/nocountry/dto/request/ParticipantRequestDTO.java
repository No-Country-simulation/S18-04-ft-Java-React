package com.nocountry.nocountry.dto.request;

import com.nocountry.nocountry.dto.response.SessionResponseDTO;
import com.nocountry.nocountry.dto.response.SurveyResponseDTO;
import com.nocountry.nocountry.dto.response.TeamResponseDTO;
import lombok.Data;

import java.util.List;

@Data
public class ParticipantRequestDTO {
    private Boolean isTl;
    private TeamResponseDTO team;
    private List<SurveyResponseDTO> participants;
    private List<SurveyResponseDTO> buddy;
    private  List<SessionResponseDTO>sessions;
}
