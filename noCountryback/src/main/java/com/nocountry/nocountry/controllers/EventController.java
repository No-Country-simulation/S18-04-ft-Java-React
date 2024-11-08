package com.nocountry.nocountry.controllers;

import com.nocountry.nocountry.config.mapper.EventMapper;
import com.nocountry.nocountry.dto.request.EventRequestDTO;
import com.nocountry.nocountry.dto.response.EventResponseDTO;
import com.nocountry.nocountry.dto.response.TeamResponseDTO;
import com.nocountry.nocountry.models.Event;
import com.nocountry.nocountry.services.IEventService;
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
@RequestMapping("/api/events")
public class EventController {

    private final IEventService service;
    private final EventMapper mapper;

    public EventController(IEventService service, EventMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventResponseDTO> findById(@PathVariable("id")  UUID id) {
        return ResponseEntity.ok(mapper.toEventDTO(service.findById(id)));
    }

    @PostMapping
    public ResponseEntity<EventResponseDTO> save(@Valid @RequestBody EventRequestDTO dto) {
        return ResponseEntity.status(201).body(mapper.toEventDTO(service.create(mapper.toEvent(dto))));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventResponseDTO> update(@Valid @RequestBody EventRequestDTO dto, @PathVariable("id")  UUID id) {
        return ResponseEntity.status(200).body(mapper.toEventDTO(service.updateById(mapper.toEvent(dto), id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") UUID id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/page")
    public ResponseEntity<Page<EventResponseDTO>> findAll(
            @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "eventName") String sortField, @RequestParam(defaultValue = "desc") String sortOrder) {
        List<EventResponseDTO> list = service.findAllPage(page,size,sortField,sortOrder).stream().map(mapper::toEventDTO).collect(Collectors.toList());
        Page<EventResponseDTO> listResponse = new PageImpl<>(list);
        return new ResponseEntity<>(listResponse, HttpStatus.OK);
    }
}