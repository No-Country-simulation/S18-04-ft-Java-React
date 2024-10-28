package com.nocountry.nocountry.controllers;

import com.nocountry.nocountry.config.mapper.EventRecordMapper;
import com.nocountry.nocountry.config.mapper.FrameworkMapper;
import com.nocountry.nocountry.config.mapper.LanguagesMapper;
import com.nocountry.nocountry.config.mapper.RoleTypeMapper;
import com.nocountry.nocountry.dto.request.EventRecordRequestDTO;
import com.nocountry.nocountry.dto.request.RoleTypeRequestDTO;
import com.nocountry.nocountry.dto.response.*;
import com.nocountry.nocountry.models.EventRecord;
import com.nocountry.nocountry.models.Framework;
import com.nocountry.nocountry.models.Languages;
import com.nocountry.nocountry.models.RoleType;
import com.nocountry.nocountry.models.enums.Schedule;
import com.nocountry.nocountry.services.IEventRecordService;
import com.nocountry.nocountry.services.IFrameworkService;
import com.nocountry.nocountry.services.ILanguagesService;
import com.nocountry.nocountry.services.IRoleTypeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/event-records")
@RequiredArgsConstructor
public class EventRecordController {

    private final IEventRecordService service;
    private final IRoleTypeService roleTypeService;
    private final ILanguagesService languagesService;
    private final IFrameworkService frameworkService;

    private final EventRecordMapper mapper;
    private final RoleTypeMapper roleTypeMapper;
    private final LanguagesMapper languagesMapper;
    private final FrameworkMapper frameworkMapper;


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

    //Controller asignacion de registros y equipos
    @PostMapping("/update-assigned-records")
    public ResponseEntity<String> updateAssignedRecords(
            @RequestParam UUID eventNum,
            @RequestParam String scheduleNom,
            @RequestParam String frameworkFront,
            @RequestParam int frontQuantity,
            @RequestParam int backQuantity,
            @RequestParam int qaQuantity,
            @RequestParam int pmQuantity,
            @RequestParam int uxQuantity) {

        service.updateAssignedRecords(eventNum, scheduleNom, frameworkFront,
                frontQuantity, backQuantity, qaQuantity,
                pmQuantity, uxQuantity);
        return ResponseEntity.ok("Procedimiento almacenado ejecutado exitosamente.");
    }

    @GetMapping("/register-form/{projectType}")
    public ResponseEntity<RegisterRecordDTO>findAllForms(@PathVariable("projectType") UUID projectType) {
        List<RoleTypeResponseDTO> roles = roleTypeService.findAllByProjectType(projectType).stream().map(roleTypeMapper::toRoleTypeResponseDTO).collect(Collectors.toList());
        List<LanguagesResponseDTO>languages = languagesService.getAll().stream().map(languagesMapper::toLanguagesResponseDTO).collect(Collectors.toList());
        List<FrameworkResponseDTO> frameworks = frameworkService.getAll().stream().map(frameworkMapper::toFrameworkDTO).collect(Collectors.toList());
        List<String> schedules = List.of("Manana","Tarde","Noche","FullTime");
        RegisterRecordDTO registerForm = new RegisterRecordDTO(roles, languages, schedules, frameworks);
        return ResponseEntity.ok(registerForm);
    }
}
