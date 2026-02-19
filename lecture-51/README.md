# Lecture 51 - Database Integrations Using MongoDB (Contd)

## Goal
Connect our Student Management Spring Boot project to MongoDB using Spring Data MongoDB and validate the CRUD milestones using API calls and MongoDB Compass.

## Quick links
- Lecture PDF: [Lecture 51 - Database Integrations using MongoDB (Contd)](./lecture/Lecture%2051_%20Database%20Integrations%20using%20MongoDB%20(Contd).pdf)
- Live coding project: [spring-boot-intro](./live-coding/spring-boot-intro)

## What we covered
- What it means to make the project "Mongo-backed" (Spring Data MongoDB + MongoDB URI)
- Mapping a Java model to a MongoDB collection using annotations
- Creating a repository layer with `MongoRepository`
- Enforcing unique email behavior (code-side checks + MongoDB unique index)
- Verifying outcomes using API requests and MongoDB Compass

## Live coding
### Project
- Folder: [live-coding/spring-boot-intro](./live-coding/spring-boot-intro)
- Entry point: [`SpringBootIntroApplication.java`](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/SpringBootIntroApplication.java)

### What to notice (key parts)
- MongoDB config:
  - [`application.properties`](./live-coding/spring-boot-intro/src/main/resources/application.properties)
- Model mapping:
  - [`Student.java`](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/model/Student.java)
- Repository:
  - [`StudentRepository.java`](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/repo/StudentRepository.java)
- Service and validation flow:
  - [`StudentService.java`](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/service/StudentService.java)
- API layer:
  - [`StudentController.java`](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/controller/StudentController.java)
- Error handling:
  - [`GlobalExceptionHandler.java`](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/error/GlobalExceptionHandler.java)
  - [`DuplicateEmailException.java`](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/exception/DuplicateEmailException.java)
  - [`StudentNotFoundException.java`](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/exception/StudentNotFoundException.java)

## Running and testing
- Open the project: `live-coding/spring-boot-intro`
- Ensure MongoDB is reachable using the URI configured in:
  - [`application.properties`](./live-coding/spring-boot-intro/src/main/resources/application.properties)
