Phase 4 – Kafka Event Publishing

Objective
This phase introduces event-driven architecture using Kafka. When a booking is confirmed, the system publishes a domain event.

Project Impact
Spring Kafka dependency is added.
A BookingEvent contract is defined.
BookingService publishes BOOKING_CONFIRMED events after successful bookings.
A Kafka consumer skeleton is introduced.

Outcome
The booking process now triggers asynchronous events. The foundation for projections and background processing is established.