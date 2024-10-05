package com.nocountry.nocountry.config.mapper;


import com.nocountry.nocountry.dto.request.EventRequestDTO;
import com.nocountry.nocountry.dto.response.EventResponseDTO;
import com.nocountry.nocountry.models.Event;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EventMapper {

    EventMapper INSTANCE = Mappers.getMapper(EventMapper.class);

    @Mapping(source = "eventType", target = "eventType")
    @Mapping(source = "eventName", target = "eventName")
    @Mapping(source = "eventDescription", target = "eventDescription")
    @Mapping(source = "eventParticipant", target = "eventParticipant")
    @Mapping(source = "eventDateStart", target = "eventDateStart")
    @Mapping(source = "eventDateEnd", target = "eventDateEnd")
    Event toEvent(EventRequestDTO dto);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "eventType", target = "eventType")
    @Mapping(source = "eventName", target = "eventName")
    @Mapping(source = "eventDescription", target = "eventDescription")
    @Mapping(source = "eventParticipant", target = "eventParticipant")
    @Mapping(source = "eventDateStart", target = "eventDateStart")
    @Mapping(source = "eventDateEnd", target = "eventDateEnd")
    EventResponseDTO toEventDTO(Event event);
}
