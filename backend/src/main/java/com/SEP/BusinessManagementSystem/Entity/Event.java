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

    public Event() {}

    public Event(Long requestId, LocalDate dateOfEvent, String name, LocalTime timeOfEvent, String place) {
        this.id = requestId;
        this.dateOfEvent = dateOfEvent;
        this.name = name;
        this.timeOfEvent = timeOfEvent;
        this.place = place;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateOfEvent() {
        return dateOfEvent;
    }

    public void setDateOfEvent(LocalDate dateOfEvent) {
        this.dateOfEvent = dateOfEvent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalTime getTimeOfEvent() {
        return timeOfEvent;
    }

    public void setTimeOfEvent(LocalTime timeOfEvent) {
        this.timeOfEvent = timeOfEvent;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
