package com.nocountry.nocountry.repository;

import com.nocountry.nocountry.models.EventRecord;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface EventRecordRepo extends GenericRepo<EventRecord, UUID> {

    @Procedure(procedureName = "UpdateAssignedRecords")
    void callUpdateAssignedRecords(
            @Param("eventNum") UUID eventNum,
            @Param("scheduleNom") String scheduleNom,
            @Param("frameworkFront") String frameworkFront,
            @Param("frontQuantity") int frontQuantity,
            @Param("backQuantity") int backQuantity,
            @Param("qaQuantity") int qaQuantity,
            @Param("pmQuantity") int pmQuantity,
            @Param("uxQuantity") int uxQuantity
    );
}
