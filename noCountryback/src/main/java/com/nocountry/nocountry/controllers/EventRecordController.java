package com.nocountry.nocountry.controllers;

import com.nocountry.nocountry.config.mapper.EventRecordMapper;
import com.nocountry.nocountry.dto.request.EventRecordRequestDTO;
import com.nocountry.nocountry.dto.response.EventRecordResponseDTO;
import com.nocountry.nocountry.models.EventRecord;
import com.nocountry.nocountry.services.IEventRecordService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/event-records")
public class EventRecordController {

    private final IEventRecordService service;
    private final EventRecordMapper mapper;

    public EventRecordController(IEventRecordService service, EventRecordMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventRecordResponseDTO> findById(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(mapper.toEventRecordDTO(service.findById(id)));
    }

    @PostMapping
    public ResponseEntity<EventRecordResponseDTO> save(@Valid @RequestBody EventRecordRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(mapper.toEventRecordDTO(service.create(mapper.toEventRecord(dto))));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventRecordResponseDTO> update(@Valid @RequestBody EventRecordRequestDTO dto, @PathVariable("id") UUID id) {
        return ResponseEntity.ok(mapper.toEventRecordDTO(service.updateById(mapper.toEventRecord(dto), id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/page")
    public ResponseEntity<Page<EventRecordResponseDTO>> findAll(
            @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "eventName") String sortField, @RequestParam(defaultValue = "desc") String sortOrder) {
        Page<EventRecord> eventRecordsPage = service.findAllPage(page, size, sortField, sortOrder);
        List<EventRecordResponseDTO> eventRecordResponseDTOs = eventRecordsPage.getContent()
                .stream()
                .map(mapper::toEventRecordDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(new PageImpl<>(eventRecordResponseDTOs,
                eventRecordsPage.getPageable(),
                eventRecordsPage.getTotalElements()));
    }

    @GetMapping("/find_all_by_user_id")
    public ResponseEntity<List<EventRecordResponseDTO>> findAllEventsByUserId(
            @RequestBody String userId){
        return ResponseEntity.ok(service.findAllEventByUserId(userId)
                .stream().map(mapper::toEventRecordDTO).collect(Collectors.toList()));
    }
}
