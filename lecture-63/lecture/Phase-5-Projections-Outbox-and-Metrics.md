Phase 5 – Projections: Email Outbox and Metrics

Objective
This phase demonstrates how events can be consumed to create projections. Two projections are introduced: an email outbox and hourly booking metrics.

Project Impact
A Mongo collection for email_outbox is introduced.
A Mongo collection for booking_metrics_hourly is introduced.
Kafka consumer writes to both collections when a booking event is received.
A metrics endpoint exposes bookings per hour for reporting.

Outcome
The system now demonstrates how event-driven systems create derived data models for notifications and analytics without modifying the core booking flow.