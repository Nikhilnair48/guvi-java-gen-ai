package com.guvi.kafka;

import java.time.Instant;

import com.guvi.model.Booking;
import com.guvi.model.BookingStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * eventId, bookingId, userId
 * Key - eventId
 * Value - BookingEvent
 */

@Component
public class BookingEventProducer {
    private final KafkaTemplate<Object, Object> kafkaTemplate;
    private final String EVENT_REGISTRATION_TOPIC = "event.registration.bookings";

    public BookingEventProducer(KafkaTemplate<Object, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    /**
     * Purpose: publish the booking confirmation
     * Publish BOOKING_CONFIRMED events
     */
    public void publishBookingConfirmation(Booking booking) {
        /*
        String eventName, String eventId, String bookingId, String userId,
                        int numberOfSeats, double price, Instant occurredAt
         */
        BookingEvent payload = new BookingEvent(
            BookingEventType.BOOKING_CONFIRMED.name(),
            booking.getEventId(),
            booking.getId(),
            booking.getUserId(),
            booking.getNumberOfSeats(),
            Instant.now()
        );

        kafkaTemplate.send(EVENT_REGISTRATION_TOPIC, booking.getEventId(), payload);
    }
}
