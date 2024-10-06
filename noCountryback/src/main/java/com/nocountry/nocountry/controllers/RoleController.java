package com.nocountry.nocountry.controllers;

import com.nocountry.nocountry.config.mapper.RoleMapper;
import com.nocountry.nocountry.dto.request.RoleRequestDTO;
import com.nocountry.nocountry.dto.response.RoleResponseDTO;
import com.nocountry.nocountry.models.Role;
import com.nocountry.nocountry.services.IRoleService;
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
@RequestMapping("/api/roles")
public class RoleController {

    private final IRoleService service;
    private final RoleMapper mapper;

    public RoleController(IRoleService service, RoleMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleResponseDTO> findById(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(mapper.toRoleResponseDTO(service.findById(id)));
    }

    @PostMapping
    public ResponseEntity<RoleResponseDTO> save(@Valid @RequestBody RoleRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(mapper.toRoleResponseDTO(service.create(mapper.toRole(dto))));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoleResponseDTO> update(@Valid @RequestBody RoleRequestDTO dto, @PathVariable("id") UUID id) {
        return ResponseEntity.ok(mapper.toRoleResponseDTO(service.updateById(mapper.toRole(dto), id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") UUID id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/page")
    public ResponseEntity<Page<RoleResponseDTO>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "roleName") String sortField,
            @RequestParam(defaultValue = "asc") String sortOrder) {
        Page<Role> rolesPage = service.findAllPage(page, size, sortField, sortOrder);
        List<RoleResponseDTO> roleResponseDTOs = rolesPage.getContent()
                .stream()
                .map(mapper::toRoleResponseDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(new PageImpl<>(roleResponseDTOs, rolesPage.getPageable(), rolesPage.getTotalElements()), HttpStatus.OK);
    }
}
