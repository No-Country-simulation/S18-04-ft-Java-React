package com.nocountry.nocountry.controllers;

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

    public EventController(IEventService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingResponseDTO> findById(
            @PathVariable("id")  UUID id) {
        Booking obj = service.findById(id);
        if (obj == null) {
            throw new NotAuthorizedException("ID NOT FOUND: " + id);
        } else {
            return new ResponseEntity<>(mapper.toBookingDTO(obj), HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<BookingResponseDTO> save(@Valid @RequestBody BookingRequestDTO dto, @CurrentUser UserPrincipal user) {
        BookingResponseDTO obj = service.save(mapper.toBooking(dto), user);
        return ResponseEntity.status(201).body(obj);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Booking> update(@Valid @RequestBody BookingRequestDTO dto,
                                          @PathVariable("id") @Parameter(name = "id", description = "ID del Reserva", example = "6097656c-e788-45cb-a41f-73d4e031ee60") UUID id) {
        Booking obj = service.updateById(id, mapper.toBooking(dto));
        return ResponseEntity.status(200).body(obj);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") @Parameter(example = "") UUID id) {
        Booking obj = service.findById(id);
        if (obj == null) {
            throw new NotFoundException("ID NOT FOUND: " + id);
        }
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping
    public ResponseEntity<Page<BookingResponseDTO>> findAll(@RequestParam(defaultValue = "0") int page,
                                                            @RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "bookingReason") String sortField,
                                                            @RequestParam(defaultValue = "desc") String sortOrder) {
        try {

            List<BookingResponseDTO> list = service.findAll(page, size, sortField, sortOrder).stream()
                    .map(p -> mapper.toBookingDTO(p)).collect(Collectors.toList());
            Page<BookingResponseDTO> listResponse = new PageImpl<>(list);
            return new ResponseEntity<>(listResponse, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener reservas", e);
        }
    }

}
