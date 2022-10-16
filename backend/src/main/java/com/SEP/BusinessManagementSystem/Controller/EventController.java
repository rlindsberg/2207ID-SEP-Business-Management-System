package com.SEP.BusinessManagementSystem.Controller;

import com.SEP.BusinessManagementSystem.Entity.Event;
import com.SEP.BusinessManagementSystem.Entity.Request;
import com.SEP.BusinessManagementSystem.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping("/api/v1/events")
public class EventController {
    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }


    @GetMapping("/get/{requestId}")
    public ResponseEntity<?> getEventByRequestId(@PathVariable Long requestId){
        return ResponseEntity.ok().body(eventService.getEventByRequestId(requestId));
    }

    @PostMapping("/create/{requestId}")
    public ResponseEntity<?> createNewEvent(@PathVariable Long requestId, @RequestBody Event eventDetails) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("events/create").toUriString());
        return ResponseEntity.created(uri).body(eventService.createNewEvent(requestId, eventDetails));
    }
}
