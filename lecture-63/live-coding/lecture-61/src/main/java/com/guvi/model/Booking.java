package com.guvi.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Booking document stored in MongoDB.
 *
 * IMPORTANT:
 * - We add @Id so MongoRepository can treat "id" as the document ID.
 * - We add a no-arg constructor so Spring/Jackson can deserialize it from JSON.
 */
@Document(collection = "bookings")
public class Booking {

    @Id
    private String id;

    private String eventId;
    private String userId;

    // number of seats booked in this booking
    private int numberOfSeats;

    private BookingStatus status;
    private LocalDateTime createdAt;

    // REQUIRED for Jackson + Spring Data
    public Booking() {}

    // Convenience constructor (not required for REST)
    public Booking(String id, String eventId, String userId, int numberOfSeats) {
        this.id = id;
        this.eventId = eventId;
        this.userId = userId;
        this.numberOfSeats = numberOfSeats;
        this.status = BookingStatus.CONFIRMED;
        this.createdAt = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
