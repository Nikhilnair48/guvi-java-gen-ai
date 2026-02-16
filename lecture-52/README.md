# Lecture 52 - Database Integrations Using MongoDB

## Goal
Complete Student CRUD endpoints using Spring Data MongoDB, improve API behavior for exception scenarios, and verify using API calls and MongoDB Compass.

## Quick links
- Lecture PDF: [Lecture 52 - Database Integrations using MongoDB](./lecture/Lecture%2052_%20Database%20Integrations%20using%20MongoDB.pdf)
- Discussion notes: [Discussion-Notes.md](./lecture/Discussion-Notes.md)
- Live coding project: [spring-boot-intro](./live-coding/spring-boot-intro)

## What we covered
- MongoDB mapping annotations (`@Document`, `@Id`, `@Indexed`)
- MongoRepository and derived query methods
- CRUD endpoints for Student using MongoDB persistence
- Validation and predictable error outcomes using exceptions + handler

## Live coding
### Project
- Folder: [live-coding/spring-boot-intro](./live-coding/spring-boot-intro)
- Entry point: [`SpringBootIntroApplication.java`](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/SpringBootIntroApplication.java)

### What to notice (key parts)
- MongoDB config:
  - [`application.properties`](./live-coding/spring-boot-intro/src/main/resources/application.properties)
- API endpoints:
  - [`StudentController.java`](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/controller/StudentController.java)
- Request DTO:
  - [`CreateStudentRequest.java`](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/dto/CreateStudentRequest.java)
- Core CRUD logic:
  - [`StudentService.java`](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/service/StudentService.java)
- Repository:
  - [`StudentRepository.java`](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/repo/StudentRepository.java)
- Error handling:
  - [`GlobalExceptionHandler.java`](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/error/GlobalExceptionHandler.java)
  - [`DuplicateEmailException.java`](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/exception/DuplicateEmailException.java)
  - [`StudentNotFoundException.java`](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/exception/StudentNotFoundException.java)

## Running and testing
- Open the project: `live-coding/spring-boot-intro`
- Ensure MongoDB is reachable using the URI configured in:
  - [`application.properties`](./live-coding/spring-boot-intro/src/main/resources/application.properties)
