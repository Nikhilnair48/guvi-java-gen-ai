# Lecture 49: Search, Filters, Pagination, Sorting (API Inputs + Validation + Errors)

## Quick links
- Lecture PDF: [Lecture 49 - Search, Filters, Pagination, Sorting](./lecture/Lecture%2049_%20Search,%20Filters,%20Pagination,%20Sorting.pdf)
- Live coding: [spring-boot-intro](./live-coding/spring-boot-intro/)
- Controller: [StudentController.java](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/controller/StudentController.java)
- Global error handling: [GlobalExceptionHandler.java](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/error/GlobalExceptionHandler.java)

## Goal
Expand the Student API to accept structured input cleanly (path variables, request body, validations) and return meaningful error responses via a global handler.

## Materials
- [Lecture PDF](./lecture/Lecture%2049_%20Search,%20Filters,%20Pagination,%20Sorting.pdf)
- Live coding project: [spring-boot-intro](./live-coding/spring-boot-intro/)

## What we covered
- Spring MVC annotations used in real APIs:
  - `@RequestMapping`, `@GetMapping`, `@PostMapping`, `@PutMapping`
  - `@PathVariable`, `@RequestBody`
- Triggering validation with `@Valid`
- Global exception handling with `@RestControllerAdvice`
- Converting domain errors to HTTP responses (example: duplicate email, missing student)

## Live coding
### Project: spring-boot-intro
- Controller:
  - [StudentController.java](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/controller/StudentController.java)
- Validation DTO:
  - [CreateStudentRequest.java](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/dto/CreateStudentRequest.java)
- Exceptions + handler:
  - [DuplicateEmailException.java](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/exception/DuplicateEmailException.java)
  - [StudentNotFoundException.java](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/exception/StudentNotFoundException.java)
  - [GlobalExceptionHandler.java](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/error/GlobalExceptionHandler.java)

## API surface (what learners can call)
- GET `/students`
- GET `/students/{id}`
- POST `/students`
- PUT `/students/{id}`

## Running and testing
- Run:
  - `./mvnw spring-boot:run`
- Recommended: test endpoints using Postman (Module 4 standard).
