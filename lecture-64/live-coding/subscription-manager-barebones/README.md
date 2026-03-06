# Subscription Manager Starter (Bare Bones)

This is a starter project intended for learners to implement the APIs using in-memory storage.

What is included:
- Package structure similar to the last live-coded project
- In-memory repositories with working code
- Plan seeder that inserts a few sample plans at startup
- Placeholder controllers and services with TODO notes

What you need to implement:
- Controllers and services for plans, subscriptions, and invoices
- Business rules such as one active subscription per user
- Invoice creation on subscribe and pay flow

The app runs on port 9000.

Run:
- mvn spring-boot:run
- GET http://localhost:9000/ping
