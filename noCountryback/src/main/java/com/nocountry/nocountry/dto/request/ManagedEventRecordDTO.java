package com.nocountry.nocountry.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ManagedEventRecordDTO {

    @NotBlank
    String schedule;
    @NotBlank
    String eventId;
    @NotBlank
    String eventName;
    @NotBlank
    String frameworkFrontId;
    @NotBlank
    String languageBackId;
    @NotBlank
    String languageDevId;
    @NotBlank
    Integer backWeight;
    @NotBlank
    Integer frontWeight;
    @NotBlank
    Integer uxWeight;
    @NotBlank
    Integer qaWeight;
    @NotBlank
    Integer devWeight;
    @NotBlank
    Integer pmWeight;
    @NotBlank
    Integer numberOfTeams;
}
