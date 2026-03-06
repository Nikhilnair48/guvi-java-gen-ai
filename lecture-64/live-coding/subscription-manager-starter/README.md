# Subscription Manager Starter (In-Memory)

This is the working in-memory baseline for Roadmap Day 50.

## Run

- Java 17
- Spring Boot 4.0.1

```bash
mvn spring-boot:run
```

App runs on port 9000.

## Endpoints

- GET /ping
- GET /plans
- GET /plans/{planCode}
- POST /subscriptions
- GET /subscriptions/me
- POST /subscriptions/{id}/cancel
- GET /invoices/me
- POST /invoices/{id}/pay

## Notes

- Plans are seeded at startup in `PlanSeeder`.
- Current user is hard-coded in `CurrentUserProvider`.
- In Session 1, we will replace in-memory repositories with MySQL + JPA and replace hard-coded user with JWT.
