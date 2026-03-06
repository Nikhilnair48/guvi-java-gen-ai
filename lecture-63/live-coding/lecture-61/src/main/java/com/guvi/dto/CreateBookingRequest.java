package com.guvi.dto;

/**
 * Request body for creating a Booking.
 *
 * Why DTO:
 * - Avoid binding directly to the Mongo model (Booking) which uses primitive int.
 * - Keep the API contract minimal and stable.
 */
public class CreateBookingRequest {

    private String eventId;

    // Use wrapper type to avoid "null into int" JSON parsing failures.
    private Integer numberOfSeats;

    public CreateBookingRequest() {}

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
}