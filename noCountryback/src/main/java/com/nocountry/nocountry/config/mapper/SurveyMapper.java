package com.nocountry.nocountry.config.mapper;

import com.nocountry.nocountry.dto.request.SurveyRequestDTO;
import com.nocountry.nocountry.dto.response.SurveyResponseDTO;
import com.nocountry.nocountry.models.Survey;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SurveyMapper {

    SurveyMapper INSTANCE = Mappers.getMapper(SurveyMapper.class);

//    @Mapping(source = "participant", target = "participant")
//    @Mapping(source = "buddy", target = "buddy")
    SurveyResponseDTO toSurveyResponseDTO(Survey survey);

    @Mapping(source = "participantId", target = "participant.id")
    @Mapping(source = "buddyId", target = "buddy.id")
    Survey toSurvey(SurveyRequestDTO dto);
}
