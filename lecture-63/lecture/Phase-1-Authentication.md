Phase 1 – Authentication and Role Introduction

Objective
This phase introduces authentication into the event registration system. Users must identify themselves before accessing protected endpoints. Three roles are introduced: ADMIN, ORGANIZER, and USER.

Roles Defined
ADMIN – Full system access. Can manage events and view all bookings and metrics.
ORGANIZER – Can create and manage events, and cancel events.
USER – Can browse events and create bookings for published events.

Project Impact
Authentication is enabled using HTTP Basic authentication.
A user data model and repository are introduced.
A MongoUserDetailsService is implemented to load users from the database.
Passwords are stored in encoded form.
Security configuration defines minimal endpoint rules.

Outcome
After this phase, all existing APIs require authentication. Access rules are enforced based on roles.