package com.nocountry.nocountry.repository;

import com.nocountry.nocountry.models.EventRecord;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface EventRecordRepo extends GenericRepo<EventRecord, UUID> {

    @Query(value = "SELECT e.envent_record_id,e.schedule,e.tl,e.role_type_id,e.language_id,e.profile_id,e.event_id FROM event_records e INNER JOIN register_stack r ON r.event_record_id = e.envent_record_id INNER JOIN frameworks f ON f.framework_id = r.framework_id WHERE e.schedule =:schedule and e.role_type_id =:roleTypeId and e.language_id =:languageId and e.event_id =:eventId",nativeQuery = true)
    List<EventRecord>findAllByRegister(@Param("schedule") String schedule,@Param("roleTypeId") UUID roleTypeId,@Param("languageId") UUID languageId,@Param("eventId") UUID eventId);
}
