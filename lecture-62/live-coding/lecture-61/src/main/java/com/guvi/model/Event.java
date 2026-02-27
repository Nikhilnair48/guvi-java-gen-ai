package com.guvi.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Event document stored in MongoDB.
 *
 * NOTE for learners:
 * - This is the DB model (how we store data).
 * - The API request body should not be forced to send system-managed fields
 *   like remainingSeats / status / createdAt.
 *
 * Practical fix:
 * - We include a no-arg constructor so Jackson (for REST) and Spring Data (for Mongo)
 *   can create the object during deserialization/mapping.
 */
@Document(collection = "events")
public class Event {

    @Id
    private String id;

    private String name;
    private LocalDate eventDate;
    private String location;

    private int totalSeats;
    private int remainingSeats;

    // Replaces the earlier boolean status. This supports a real lifecycle.
    private EventStatus status;

    private float price;
    private LocalDateTime createdAt;

    // REQUIRED for Jackson + Spring Data
    public Event() {}

    public Event(String id,
                 String name,
                 LocalDate eventDate,
                 String location,
                 int totalSeats,
                 int remainingSeats,
                 float price,
                 EventStatus status,
                 LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.eventDate = eventDate;
        this.location = location;
        this.totalSeats = totalSeats;
        this.remainingSeats = remainingSeats;
        this.price = price;
        this.status = status;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public int getRemainingSeats() {
        return remainingSeats;
    }

    public void setRemainingSeats(int remainingSeats) {
        this.remainingSeats = remainingSeats;
    }

    public EventStatus getStatus() {
        return status;
    }

    public void setStatus(EventStatus status) {
        this.status = status;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
