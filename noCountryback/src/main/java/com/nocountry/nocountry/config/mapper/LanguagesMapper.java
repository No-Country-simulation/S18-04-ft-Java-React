package com.nocountry.nocountry.config.mapper;

import com.nocountry.nocountry.dto.request.LanguagesRequestDTO;
import com.nocountry.nocountry.dto.response.LanguagesResponseDTO;
import com.nocountry.nocountry.models.Languages;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface LanguagesMapper {

    LanguagesMapper INSTANCE = Mappers.getMapper(LanguagesMapper.class);

    @Mapping(source = "languageName", target = "languageName")
    @Mapping(source = "eventRecords", target = "eventRecords")
    Languages toLanguages(LanguagesRequestDTO dto);

    @Mapping(source = "languageName", target = "languageName")
    @Mapping(source = "eventRecords", target = "eventRecords")
    LanguagesResponseDTO toLanguagesResponseDTO(Languages languages);
}
