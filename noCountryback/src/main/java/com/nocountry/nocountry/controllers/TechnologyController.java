package com.nocountry.nocountry.controllers;

import com.nocountry.nocountry.config.mapper.TechnologyMapper;
import com.nocountry.nocountry.dto.request.TechnologyRequestDTO;
import com.nocountry.nocountry.dto.response.TechnologyResponseDTO;
import com.nocountry.nocountry.services.ITechnologyService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/technologies")
public class TechnologyController {
    private final ITechnologyService service;
    private final TechnologyMapper mapper;

    public TechnologyController(ITechnologyService service, TechnologyMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TechnologyResponseDTO> findById(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(mapper.toTechnologyResponseDTO(service.findById(id)));
    }

    @PostMapping
    public ResponseEntity<TechnologyResponseDTO> save(@Valid @RequestBody TechnologyRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toTechnologyResponseDTO(service.create(mapper.toTechnology(dto))));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TechnologyResponseDTO> update(@Valid @RequestBody TechnologyRequestDTO dto, @PathVariable("id") UUID id) {
        return ResponseEntity.ok(mapper.toTechnologyResponseDTO(service.update(mapper.toTechnology(dto), id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}