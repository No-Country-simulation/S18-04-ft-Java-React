package com.nocountry.nocountry.services;

import com.nocountry.nocountry.models.EventRecord;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface IEventRecordService extends ICRUDService<EventRecord, UUID> {

    List<EventRecord> findAllEventByUserId(String userId);
    void updateAssignedRecords(UUID eventNum, String scheduleNom, String frameworkFront,
                               int frontQuantity, int backQuantity, int qaQuantity,
                               int pmQuantity, int uxQuantity);
    void register_participants_in_teams(UUID eventId,String eventName);
}
