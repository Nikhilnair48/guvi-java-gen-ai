Phase 2 – Authorization Rules and API Protection

Objective
This phase defines how roles affect access to APIs. Authorization rules ensure that users can only perform actions permitted by their role.

Project Impact
Event creation and lifecycle updates are restricted to ADMIN and ORGANIZER roles.
Booking creation is restricted to USER role.
Metrics and administrative endpoints are restricted to ADMIN.
Security configuration is updated with role-based matchers.
Controllers remain largely unchanged, but access behavior changes.

Outcome
The system now enforces meaningful role-based access control instead of simple authentication.