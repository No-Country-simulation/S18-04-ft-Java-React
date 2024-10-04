package com.nocountry.nocountry.controllers;

import com.nocountry.nocountry.services.IEventService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final IEventService service;

    public EventController(IEventService service) {
        this.service = service;
    }

}
