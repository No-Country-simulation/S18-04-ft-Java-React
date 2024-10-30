package com.nocountry.nocountry.controllers;

import com.nocountry.nocountry.config.mapper.SessionMapper;
import com.nocountry.nocountry.dto.request.SessionRequestDTO;
import com.nocountry.nocountry.dto.response.EventResponseDTO;
import com.nocountry.nocountry.dto.response.SessionResponseDTO;
import com.nocountry.nocountry.models.Session;
import com.nocountry.nocountry.services.ISessionService;
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
@RequestMapping("/api/sessions")
public class SessionController {

    private final ISessionService service;
    private final SessionMapper mapper;

    public SessionController(ISessionService service, SessionMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<SessionResponseDTO> findById(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(mapper.toSessionResponseDTO(service.findById(id)));
    }

    @PostMapping
    public ResponseEntity<SessionResponseDTO> save(@Valid @RequestBody SessionRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(mapper.toSessionResponseDTO(service.create(mapper.toSession(dto))));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SessionResponseDTO> update(@Valid @RequestBody SessionRequestDTO dto, @PathVariable("id") UUID id) {
        return ResponseEntity.ok(mapper.toSessionResponseDTO(service.updateById(mapper.toSession(dto), id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") UUID id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/page")
    public ResponseEntity<Page<SessionResponseDTO>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "sessionStartTime") String sortField,
            @RequestParam(defaultValue = "desc") String sortOrder) {
        List<SessionResponseDTO> list = service.findAllPage(page,size,sortField,sortOrder).stream().map(mapper::toSessionResponseDTO).collect(Collectors.toList());
        Page<SessionResponseDTO> listResponse = new PageImpl<>(list);
        return new ResponseEntity<>(listResponse, HttpStatus.OK);
    }
}
