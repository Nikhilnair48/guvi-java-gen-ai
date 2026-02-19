# Lecture 58 - Security + Testing

## Goal
Add role-based authorization, verify 401 vs 403 behavior using Postman, and enable Swagger UI for API documentation.

## Materials
- Slides: [Lecture 58_ Security + Testing.pptx](./lecture/Lecture%2058_%20Security%20%2B%20Testing.pptx)
- PDF: [Lecture 58_ Security + Testing.pdf](./lecture/Lecture%2058_%20Security%20%2B%20Testing.pdf)

## Quick links
- Live coding project: [live-coding/spring-boot-intro](./live-coding/spring-boot-intro)
- Postman collection (course-wide): [tools/postman/GUVI-SDE-Java-AI.postman_collection.json](../tools/postman/GUVI-SDE-Java-AI.postman_collection.json)

## What we covered
- How `SecurityConfig` controls access before a controller is reached
- 401 vs 403 in our app
  - 401 when you are not authenticated
  - 403 when you are authenticated but not authorized (role mismatch)
- Role-based access rules for courses:
  - Any authenticated user can `GET /api/courses/**`
  - Only `ADMIN` can `POST`, `PUT`, `DELETE` on `/api/courses/**`
- Swagger UI for API documentation
- Repeatable API testing using Postman

## Live coding
Project: [spring-boot-intro](./live-coding/spring-boot-intro)

Entry point:
- [SpringBootIntroApplication.java](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/SpringBootIntroApplication.java)

What changed today (security + testing):
- Role-based rules:
  - [SecurityConfig.java](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/config/SecurityConfig.java)
- DB-backed Basic Auth:
  - [MongoUserDetailsService.java](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/config/MongoUserDetailsService.java)
- Password hashing as a shared bean:
  - [SecurityConfig.java](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/config/SecurityConfig.java)
  - Used by: [AuthService.java](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/service/AuthService.java)
- Swagger dependency:
  - [pom.xml](./live-coding/spring-boot-intro/pom.xml)
- Seeded users for quick testing:
  - [DataSeeder.java](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/bootstrap/DataSeeder.java)

## Running and testing
Requirements:
- Java 17
- MongoDB running locally (default is `studentdb`)
- Postman

Steps:
1. Confirm Mongo URI in:
   - [application.properties](./live-coding/spring-boot-intro/src/main/resources/application.properties)
2. Run the app:
   - `./mvnw spring-boot:run`
3. Seeder credentials (only if DB is empty):
   - Student: `student@example.com` / `password123`
   - Admin: `admin@example.com` / `admin123`
4. Verify auth behavior in Postman:
   - Public endpoint: `GET /students` (no auth)
   - Protected endpoint: `GET /api/courses`
     - No auth: expect 401
     - Student auth: expect 200
   - Role-protected write:
     - `POST /api/courses`
       - Student auth: expect 403
       - Admin auth: expect 201
5. Swagger UI:
   - Open `http://localhost:9000/swagger-ui/index.html`
