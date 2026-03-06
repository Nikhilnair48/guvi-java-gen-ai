Phase 3 – Booking Ownership and Identity from Authentication

Objective
This phase removes userId from the booking request body. The authenticated user becomes the source of truth for booking ownership.

Project Impact
BookingRequest DTO is updated to remove userId.
BookingService derives the user from the SecurityContext.
A new endpoint is introduced: GET /api/bookings/me.
The system prevents users from creating bookings on behalf of others.

Outcome
Bookings are now securely tied to the authenticated user. The API design becomes more realistic and aligned with production systems.