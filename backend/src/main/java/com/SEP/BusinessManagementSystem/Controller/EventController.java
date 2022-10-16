package com.SEP.BusinessManagementSystem.Controller;

import com.SEP.BusinessManagementSystem.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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
}
