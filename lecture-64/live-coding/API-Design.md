API Design

Invoice
- GET  /invoices/me                 (list my invoices)
- POST /invoices/{id}/pay           (mark invoice as PAID)

Plan
- GET /plans                (list active plans)
- GET /plans/{planCode}     (get plan by planCode)

Subscription
- POST /subscriptions               (subscribe to a plan)
- GET  /subscriptions/me            (current subscription + history)
- POST /subscriptions/{id}/cancel   (cancel active subscription)

Support
- GET  /support/users?emailContains=...
- GET  /support/users/{userId}/subscriptions
- GET  /support/users/{userId}/invoices
- POST /support/users/{userId}/subscriptions/{subId}/cancel



MySQL Integration with Spring Boot

pom.xml:
- Spring Boot Starter Data JPA
    - Hibernate: allows us to model our tables
- MySQL Connector/J
    - JDBC: allows us to communicate with our DB via queries


Configuration:
- DB server location, username, password, etc

Models