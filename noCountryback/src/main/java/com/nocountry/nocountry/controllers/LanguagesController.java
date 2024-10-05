package com.nocountry.nocountry.controllers;

import com.nocountry.nocountry.config.mapper.LanguagesMapper;
import com.nocountry.nocountry.dto.request.LanguagesRequestDTO;
import com.nocountry.nocountry.dto.response.LanguagesResponseDTO;
import com.nocountry.nocountry.services.ILanguagesService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {
    private final ILanguagesService service;
    private final LanguagesMapper mapper;

    public LanguagesController(ILanguagesService  service, LanguagesMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<LanguagesResponseDTO> findById(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(mapper.toLanguagesDTO(service.findById(id)));
    }

    @PostMapping
    public ResponseEntity<LanguagesResponseDTO> save(@Valid @RequestBody LanguagesRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toLanguagesDTO(service.create(mapper.toLanguages(dto))));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LanguagesResponseDTO> update(@Valid @RequestBody LanguagesRequestDTO dto, @PathVariable("id") UUID id) {
        return ResponseEntity.ok(mapper.toLanguagesDTO(service.update(mapper.toLanguages(dto), id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
