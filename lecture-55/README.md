# Lecture 55 - Authentication and Security

## Goal
Understand authentication vs authorization, how Spring Security protects REST APIs using a filter chain, and how Basic authentication maps to a DB-backed user and role model.

## Quick links
- Lecture PDF: [Lecture 55 - Authentication and Security](./lecture/Lecture%2055_%20Authentication%20and%20Security.pdf)
- Lecture PPTX: [Lecture 55 - Authentication and Security](./lecture/Lecture%2055_%20Authentication%20and%20Security.pptx)
- Live coding project: [spring-boot-intro](./live-coding/spring-boot-intro)

## What we covered
- Security foundations for APIs (why security exists, what it protects)
- Authentication vs authorization (clear definitions + examples)
- Request lifecycle and where security fits
- Spring Security at a high level (filter chain concept)
- Basic authentication and what happens on protected requests
- DB-backed users and roles (what needs to exist in the data model)
- Signup and login flow (conceptual flow for our project)
- Protected routes and role-based access (how rules apply per endpoint)
- Testing approach using Postman (workflow and success criteria)

## Live coding
### Project
- Folder: [live-coding/spring-boot-intro](./live-coding/spring-boot-intro)
- Entry point: [`SpringBootIntroApplication.java`](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/SpringBootIntroApplication.java)

### What to notice (key parts)
- Student API (same base project, continuing forward):
  - [`StudentController.java`](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/controller/StudentController.java)
- Course and enrollment API modules (API surface being introduced):
  - [`CourseController.java`](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/controller/CourseController.java)
  - [`EnrollmentController.java`](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/controller/EnrollmentController.java)
- Request DTOs:
  - [`CourseCreateRequest.java`](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/dto/CourseCreateRequest.java)
  - [`CourseUpdateRequest.java`](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/dto/CourseUpdateRequest.java)
  - [`EnrollmentCreateRequest.java`](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/dto/EnrollmentCreateRequest.java)
  - [`EnrollmentStatusUpdateRequest.java`](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/dto/EnrollmentStatusUpdateRequest.java)
- Data model additions:
  - [`Course.java`](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/model/Course.java)
  - [`Enrollment.java`](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/model/Enrollment.java)

## Running and testing
- Open the project: `live-coding/spring-boot-intro`
- Configure your MongoDB URI in:
  - [`application.properties`](./live-coding/spring-boot-intro/src/main/resources/application.properties)
