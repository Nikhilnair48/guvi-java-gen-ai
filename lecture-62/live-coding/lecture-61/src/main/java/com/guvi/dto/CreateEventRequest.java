package com.guvi.dto;

import java.time.LocalDate;

/**
 * Request body for creating an Event.
 *
 * Why DTO:
 * - Avoid binding directly to the Mongo model (Event) which has system fields
 *   and primitive types (int/float) that can cause JSON parsing issues.
 * - Client should only send what they control.
 */
public class CreateEventRequest {

    private String name;
    private String location;
    private LocalDate eventDate;

    // Use wrapper type (Integer) so missing/null values don't break JSON parsing.
    private Integer totalSeats;

    public CreateEventRequest() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public Integer getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(Integer totalSeats) {
        this.totalSeats = totalSeats;
    }
}