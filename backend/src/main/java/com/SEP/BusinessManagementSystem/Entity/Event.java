package com.SEP.BusinessManagementSystem.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table
public class Event {
    @Id
    private Long id;
    private LocalDate dateOfEvent;
    private String name;
    private LocalTime timeOfEvent;
    private String place;

    public Event() {

    }

    public Event(Long requestId, LocalDate dateOfEvent, String name, LocalTime timeOfEvent, String place) {
        this.id = requestId;
        this.dateOfEvent = dateOfEvent;
        this.name = name;
        this.timeOfEvent = timeOfEvent;
        this.place = place;
    }

}
