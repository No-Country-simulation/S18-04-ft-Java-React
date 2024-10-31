package com.nocountry.nocountry.config.mapper;

import com.nocountry.nocountry.dto.request.EventRecordRequestDTO;
import com.nocountry.nocountry.dto.response.EventRecordResponseDTO;
import com.nocountry.nocountry.models.EventRecord;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",uses = {
        FrameworkMapper.class,
        EventMapper.class,
        ProfileMapper.class,
        TeamMapper.class,
})
public interface EventRecordMapper {

    EventRecordMapper INSTANCE = Mappers.getMapper(EventRecordMapper.class);

    @Mapping(source = "schedule", target = "schedule")
    @Mapping(source = "tl", target = "tl")
    @Mapping(source = "roleType", target = "roleType")
    @Mapping(source = "stack", target = "stack")
    @Mapping(source = "language", target = "language")
    EventRecord toEventRecord(EventRecordRequestDTO dto);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "team.teamName",target = "teamName")
    @Mapping(source = "schedule", target = "schedule")
    @Mapping(source = "tl", target = "tl")
    @Mapping(source = "roleType", target = "roleType")
    @Mapping(source = "stack", target = "stack")
    @Mapping(source = "language.id", target = "languageId")
    @Mapping(source = "language.languageName", target = "languageName")
    @Mapping(source = "profile.id", target = "profileId")
    @Mapping(source = "profile.profileName", target = "profileName")
    @Mapping(source = "profile.profileLastname", target = "profileLastname")
    @Mapping(source = "event.id", target = "eventId")
    @Mapping(source = "event.eventName", target = "eventName")
    @Mapping(source = "event.eventDescription", target = "eventDescription")
    @Mapping(source = "event.eventDateStart", target = "eventDateStart")
    @Mapping(source = "event.eventDateEnd", target = "eventDateEnd")
    @Mapping(source = "event.state",target = "state")
    EventRecordResponseDTO toEventRecordDTO(EventRecord eventRecord);
}
