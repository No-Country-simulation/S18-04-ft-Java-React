package com.nocountry.nocountry.controllers;

import com.nocountry.nocountry.config.mapper.SurveyMapper;
import com.nocountry.nocountry.dto.request.SurveyRequestDTO;
import com.nocountry.nocountry.dto.response.SurveyResponseDTO;
import com.nocountry.nocountry.models.Survey;
import com.nocountry.nocountry.services.ISurveyService;
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
@RequestMapping("/api/surveys")
public class SurveyController {

    private final ISurveyService service;
    private final SurveyMapper mapper;

    public SurveyController(ISurveyService service, SurveyMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<SurveyResponseDTO> findById(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(mapper.toSurveyResponseDTO(service.findById(id)));
    }

    @PostMapping
    public ResponseEntity<SurveyResponseDTO> save(@Valid @RequestBody SurveyRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(mapper.toSurveyResponseDTO(service.create(mapper.toSurvey(dto))));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SurveyResponseDTO> update(@Valid @RequestBody SurveyRequestDTO dto, @PathVariable("id") UUID id) {
        return ResponseEntity.ok(mapper.toSurveyResponseDTO(service.updateById(mapper.toSurvey(dto), id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") UUID id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/page")
    public ResponseEntity<Page<SurveyResponseDTO>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "creationDate") String sortField,
            @RequestParam(defaultValue = "desc") String sortOrder) {
        Page<Survey> surveysPage = service.findAllPage(page, size, sortField, sortOrder);
        List<SurveyResponseDTO> surveyResponseDTOs = surveysPage.getContent()
                .stream()
                .map(mapper::toSurveyResponseDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(new PageImpl<>(surveyResponseDTOs, surveysPage.getPageable(), surveysPage.getTotalElements()), HttpStatus.OK);
    }
}
