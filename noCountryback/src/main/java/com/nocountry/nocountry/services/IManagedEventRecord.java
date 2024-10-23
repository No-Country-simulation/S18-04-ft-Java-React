package com.nocountry.nocountry.services;

import java.util.UUID;

public interface IManagedEventRecord {
    void executeManagedEventRecord(String schedule, UUID eventId, String eventName,
                                   UUID frameworkId, UUID languageBackId,
                                   UUID languageDevId, int backWeight,
                                   int frontWeight, int uxWeight,
                                   int qaWeight, int devWeight,
                                   int pmWeight, int numberOfTeams);
}
