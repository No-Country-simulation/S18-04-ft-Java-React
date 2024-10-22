package com.nocountry.nocountry.services;

import com.nocountry.nocountry.models.EventRecord;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface IEventRecordService extends ICRUDService<EventRecord, UUID> {

    List<EventRecord> findAllEventByUserId(String userId);
    List<EventRecord>findAllByRegister(String schedule, UUID roleTypeId,  UUID languageId,UUID eventId);

}
