package com.nocountry.nocountry.services;

import com.nocountry.nocountry.models.EventRecord;

import java.util.List;
import java.util.UUID;

public interface IEventRecordService extends ICRUDService<EventRecord, UUID> {

    List<EventRecord> findAllEventByUserId(String userId);
}
