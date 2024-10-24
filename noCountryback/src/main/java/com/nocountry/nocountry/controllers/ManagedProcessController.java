package com.nocountry.nocountry.controllers;

import com.nocountry.nocountry.config.mapper.EventRecordMapper;
import com.nocountry.nocountry.dto.request.ManagedEventRecordDTO;
import com.nocountry.nocountry.dto.response.EventRecordResponseDTO;
import com.nocountry.nocountry.services.IEventRecordService;
import com.nocountry.nocountry.services.IManagedEventRecord;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/managed-process")
public class ManagedProcessController {

    private final IEventRecordService service;
    private final EventRecordMapper mapper;
    private final IManagedEventRecord managedEventRecord;


    public ManagedProcessController(IEventRecordService service, EventRecordMapper mapper, IManagedEventRecord managedEventRecord) {
        this.service = service;
        this.mapper = mapper;
        this.managedEventRecord = managedEventRecord;
    }

    @PostMapping("/event-records")
    public ResponseEntity<List<EventRecordResponseDTO>> processAllByPreference(@Valid @RequestBody ManagedEventRecordDTO dto){
        managedEventRecord.executeManagedEventRecord(dto.getSchedule(), dto.getEventId(),
                dto.getEventName(), dto.getFrameworkFrontId(), dto.getLanguageBackId(),
                dto.getLanguageDevId(), dto.getBackWeight(), dto.getFrontWeight(),
                dto.getUxWeight(), dto.getQaWeight(), dto.getDevWeight(),
                dto.getPmWeight(), dto.getNumberOfTeams());
        return ResponseEntity.ok(service.getAll()
                .stream().map(mapper::toEventRecordDTO).collect(Collectors.toList()));
    }
}
