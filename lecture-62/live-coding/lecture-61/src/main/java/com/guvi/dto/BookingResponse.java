package com.guvi.dto;

import com.guvi.model.BookingStatus;
import com.guvi.model.EventStatus;

import java.time.LocalDateTime;

/**
 * API response for booking endpoints.
 *
 * We include eventStatus so that when an event is CANCELLED,
 * callers can immediately see the impact on existing bookings.
 */
public class BookingResponse {
    private String bookingId;
    private String eventId;
    private String eventName;
    private EventStatus eventStatus;

    private String userId;
    private int numberOfSeats;
    private BookingStatus bookingStatus;

    private LocalDateTime createdAt;

    public BookingResponse() {}

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public EventStatus getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(EventStatus eventStatus) {
        this.eventStatus = eventStatus;
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

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
