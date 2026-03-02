package com.guvi.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class BookingEventNotificationConsumer {
    private final Logger logger =
        LoggerFactory.getLogger(BookingEventNotificationConsumer.class);
    private final String EVENT_REGISTRATION_TOPIC = "event.registration.bookings";

    @KafkaListener(
        topics = EVENT_REGISTRATION_TOPIC,
        groupId = "booking-notification-group"
    )
    public void handleBookingEvent(BookingEvent event) {
        logger.debug("test");
        logger.info("Notification Consumer received booking event: "
            + "booking={}, userId={}", event.getBookingId(), event.getUserId());

        logger.info("Simulating email sent to userId={} for booking={}"
            ,event.getUserId(), event.getBookingId());

        logger.info("Notification email processing complete");;

    }
}
