package com.nocountry.nocountry.services;

import java.util.UUID;

public interface IManagedEventRecord {
    void executeManagedEventRecord(String schedule, String eventId, String eventName,
                                   String frameworkId, String languageBackId,
                                   String languageDevId, int backWeight,
                                   int frontWeight, int uxWeight,
                                   int qaWeight, int devWeight,
                                   int pmWeight, int numberOfTeams);
}
