package com.SEP.BusinessManagementSystem.Service;

import com.SEP.BusinessManagementSystem.Entity.Event;
import com.SEP.BusinessManagementSystem.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Service
public class EventService {
    private final EventRepository eventRepository;


    @Autowired
    public EventService(EventRepository eventRepository) {

        this.eventRepository = eventRepository;
    }

    @GetMapping
    public Event getEventByRequestId(Long requestId){
        Optional<Event> eventOptional = eventRepository.findById(requestId);
        if (eventOptional.isEmpty()) {
            throw new RuntimeException("Event not found!");
        }
        return eventOptional.get();
    }
}
