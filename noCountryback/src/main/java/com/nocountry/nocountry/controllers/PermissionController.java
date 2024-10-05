package com.nocountry.nocountry.controllers;

import com.nocountry.nocountry.config.mapper.PermissionMapper;
import com.nocountry.nocountry.dto.request.PermissionRequestDTO;
import com.nocountry.nocountry.dto.response.PermissionResponseDTO;
import com.nocountry.nocountry.services.IPermissionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/permissions")
public class PermissionController {
    private final IPermissionService service;
    private final PermissionMapper mapper;

    public PermissionController(IPermissionService service, PermissionMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PermissionResponseDTO> findById(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(mapper.toPermissionResponseDTO(service.findById(id)));
    }

    @PostMapping
    public ResponseEntity<PermissionResponseDTO> save(@Valid @RequestBody PermissionRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toPermissionResponseDTO(service.create(mapper.toPPermission(dto))));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PermissionResponseDTO> update(@Valid @RequestBody PermissionRequestDTO dto, @PathVariable("id") UUID id) {
        return ResponseEntity.ok(mapper.toPermissionResponseDTO(service.update(mapper.toPPermission(dto), id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<PermissionResponseDTO>> findAll() {
        return ResponseEntity.ok(service.getAll().stream()
                .map(mapper::toPermissionResponseDTO)
                .collect(Collectors.toList()));
    }
}