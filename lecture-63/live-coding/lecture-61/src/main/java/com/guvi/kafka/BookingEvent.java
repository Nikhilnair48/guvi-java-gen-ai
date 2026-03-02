package com.guvi.kafka;

import java.time.Instant;

/**
 - name of the event
 - eventId, bookingId, userId
 - # of seats, price..
 - occurredAt...
 */
public class BookingEvent {
    private String eventName;
    private String eventId;
    private String bookingId;
    private String userId;
    private int numberOfSeats;
    // private double price;
    private Instant occurredAt;

    public BookingEvent() {
    }

    // double price,
    public BookingEvent(String eventName, String eventId, String bookingId, String userId,
                        int numberOfSeats, Instant occurredAt) {
        this.eventName = eventName;
        this.eventId = eventId;
        this.bookingId = bookingId;
        this.userId = userId;
        this.numberOfSeats = numberOfSeats;
        // this.price = price;
        this.occurredAt = occurredAt;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
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

//    public double getPrice() {
//        return price;
//    }
//
//    public void setPrice(double price) {
//        this.price = price;
//    }

    public Instant getOccurredAt() {
        return occurredAt;
    }

    public void setOccurredAt(Instant occurredAt) {
        this.occurredAt = occurredAt;
    }
}
