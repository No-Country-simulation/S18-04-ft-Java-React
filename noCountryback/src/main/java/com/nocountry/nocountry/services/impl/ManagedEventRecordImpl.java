package com.nocountry.nocountry.services.impl;

import com.nocountry.nocountry.models.*;
import com.nocountry.nocountry.services.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class ManagedEventRecordImpl implements IManagedEventRecord {

    private final IEventRecordService eventRecordService;
    private final IParticipantService participantService;
    private final ITeamService teamService;
    private final IFrameworkService frameworkService;
    private final ILanguagesService languagesService;

    @Autowired
    public ManagedEventRecordImpl(IEventRecordService eventRecordService,
                                  IParticipantService participantService,
                                  ITeamService teamService,
                                  IFrameworkService frameworkService,
                                  ILanguagesService languagesService) {
        this.eventRecordService = eventRecordService;
        this.participantService = participantService;
        this.teamService = teamService;
        this.frameworkService = frameworkService;
        this.languagesService = languagesService;
    }

    private final String back = "d5e737ac-316e-46fb-92a6-77aa149ee8e6";
    private final String front = "54d5c728-3757-4968-a35d-28edb51b2795";
    private final String ux = "151e9ec2-921d-43a4-9a57-b12319c99439";
    private final String qa = "b6daedcf-b311-473d-b8e1-33354c2220e6";
    private final String devops = "709814fb-cd6a-47b1-8ff6-83db4f38bc72";
    private final String pm = "8f562cce-cfac-4452-a25e-e1784a88a15e";

    private final Random random = new Random();
    private final HashMap<String, Integer> weighPerTeam = new HashMap<>();
    private List<EventRecord> backList, frontList, uxList, qaList, devList, pmList;

    /**
     * Función encargada de gestionar Listas de EventRecord, Team y Participant
     * @param schedule Horario a filtrar
     * @param eventId Identificador del Evento
     * @param eventName Nombre del Evento
     * @param frameworkFrontId Identificador del Framework para Frontend
     * @param languageBackId Identificador del Lenguaje para Backend
     * @param languageDevId Identificador del Lenguaje para DevOps
     * @param backWeight Proporción de Integrantes en el Rol de Backend por equipo
     * @param frontWeight Proporción de Integrantes en el Rol de Frontend por equipo
     * @param uxWeight Proporción de Integrantes en el Rol de UX/UI por equipo
     * @param qaWeight Proporción de Integrantes en el Rol de QA por equipo
     * @param devWeight Proporción de Integrantes en el Rol de DevOps por equipo
     * @param pmWeight Proporción de Integrantes en el Rol de PM por equipo
     * @param numberOfTeams Cantidad de Equipos a crear
     */
    @Override
    public void executeManagedEventRecord(String schedule, UUID eventId, String eventName,
                                          UUID frameworkFrontId, UUID languageBackId,
                                          UUID languageDevId, int backWeight,
                                          int frontWeight, int uxWeight,
                                          int qaWeight, int devWeight,
                                          int pmWeight, int numberOfTeams) {
        initPreParticipants(schedule, eventId, frameworkFrontId, languageBackId, languageDevId);
        initWeighPerTeam(backWeight, frontWeight, uxWeight, qaWeight, devWeight, pmWeight);
        createTeams(numberOfTeams, eventName, schedule, frameworkFrontId, languageBackId);
    }

    private void initPreParticipants(String schedule, UUID eventId,
                                     UUID frameworkFrontId, UUID languageBackId, UUID languageDevId) {
        backList = fetchEventRecords(schedule, back, languageBackId, eventId, null);
        frontList = fetchEventRecords(schedule, front, null, eventId, frameworkFrontId);
        uxList = fetchEventRecords(schedule, ux, null, eventId, null);
        qaList = fetchEventRecords(schedule, qa, null, eventId, null);
        devList = fetchEventRecords(schedule, devops, languageDevId, eventId, null);
        pmList = fetchEventRecords(schedule, pm, null, eventId, null);
    }

    private List<EventRecord> fetchEventRecords(String schedule, String teamId,
                                                UUID langId, UUID eventId, UUID frameworkId) {
        return eventRecordService.findAllByRegister(schedule, UUID.fromString(teamId),
                langId, eventId, frameworkId);
    }

    private void initWeighPerTeam(int back, int front, int ux, int qa, int dev,
                                  int pm) {
        weighPerTeam.put("back", back);
        weighPerTeam.put("front", front);
        weighPerTeam.put("ux", ux);
        weighPerTeam.put("qa", qa);
        weighPerTeam.put("dev", dev);
        weighPerTeam.put("pm", pm);
    }

    private void createTeams(int numberOfTeams, String eventName, String schedule,
                             UUID frameworkFrontId, UUID languageBackId) {
        Framework frameworkFront = frameworkService.findById(frameworkFrontId);
        Languages languageBack = languagesService.findById(languageBackId);
        for (int i = 1; i <= numberOfTeams; i++) {
            createTeam(i, eventName, schedule, frameworkFront, languageBack);
        }
    }

    private void createTeam(int teamId, String eventName, String schedule,
                            Framework frameworkFront, Languages languageBack) {
        Team team = new Team();
        team.setTeamName(generateTeamName(eventName, teamId, schedule, frameworkFront, languageBack));
        teamService.create(team);

        assignParticipantsToTeam(team, "back", backList);
        assignParticipantsToTeam(team, "front", frontList);
        assignParticipantsToTeam(team, "ux", uxList);
        assignParticipantsToTeam(team, "qa", qaList);
        assignParticipantsToTeam(team, "dev", devList);
        assignParticipantsToTeam(team, "pm", pmList);
    }

    private void assignParticipantsToTeam(Team team, String role, List<EventRecord> list) {
        int count = weighPerTeam.get(role);
        list.stream().limit(count).forEach(eventRecord ->
                        createParticipant(list.remove(randomWithRange(list.size())), team));
    }

    private void createParticipant(EventRecord eventRecord, Team team) {
        Participant participant = new Participant();
        participant.setEventRecord(eventRecord);
        participant.setTeam(team);
        participantService.create(participant);
    }

    private String generateTeamName(String eventName, int teamId, String schedule,
                                    Framework frameworkFront, Languages languageBack) {
        return String.format("%s-%d-%s-%s-%s", eventName, teamId, schedule,
                languageBack.getLanguageName(), frameworkFront.getFrameworkName());
    }

    private int randomWithRange(int max) {
        return random.nextInt(max);
    }
}
