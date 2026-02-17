# Lecture 56 - Authentication and Security

## Goal
Implement signup and login backed by MongoDB, then add basic security rules for API endpoints.

## Materials
- Slides: [Lecture 56_ Authentication and Security.pptx](./lecture/Lecture%2056_%20Authentication%20and%20Security.pptx)
- PDF: [Lecture 56_ Authentication and Security.pdf](./lecture/Lecture%2056_%20Authentication%20and%20Security.pdf)

## Quick links
- Live coding project: [live-coding/spring-boot-intro](./live-coding/spring-boot-intro)
- Postman collection (course-wide): [tools/postman/GUVI-SDE-Java-AI.postman_collection.json](../tools/postman/GUVI-SDE-Java-AI.postman_collection.json)

## What we covered
- Users collection basics: storing users with `email`, `passwordHash`, `roles`, `active`
- Signup flow: create a user and store a hashed password
- Login flow: validate password using BCrypt
- SecurityConfig basics:
  - Public: `POST /auth/**`
  - Protected: `/api/**` (requires authentication)
  - Public: `/students/**`

## Live coding
Project: [spring-boot-intro](./live-coding/spring-boot-intro)

Entry point:
- [SpringBootIntroApplication.java](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/SpringBootIntroApplication.java)

Key areas:
- Auth endpoints:
  - [AuthController.java](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/controller/AuthController.java)
  - [AuthService.java](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/service/AuthService.java)
  - DTOs: [dto/](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/dto/)
- Security rules:
  - [SecurityConfig.java](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/config/SecurityConfig.java)
- Existing APIs (protected under `/api/**`):
  - [CourseController.java](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/controller/CourseController.java)
  - [EnrollmentController.java](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/controller/EnrollmentController.java)
- Public students API:
  - [StudentController.java](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/controller/StudentController.java)

## Running and testing
Requirements:
- Java 17
- MongoDB running locally or a reachable MongoDB URI
- Postman (recommended)

Steps:
1. Set Mongo URI in:
   - [application.properties](./live-coding/spring-boot-intro/src/main/resources/application.properties)
2. Run the app:
   - `./mvnw spring-boot:run`
3. Test with Postman:
   - Call `POST /auth/signup`
   - Call `POST /auth/login`
   - Call a protected endpoint like `GET /api/courses`:
     - Without auth: expect 401
     - With Basic Auth: should pass authentication (credentials depend on your current security setup)
