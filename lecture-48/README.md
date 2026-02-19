# Lecture 48: Spring Boot Fundamentals

## Quick links
- Lecture PDF: [Lecture 48 - Spring Boot Fundamentals](./lecture/Lecture%2048_%20Module%204%20-%20Spring%20Boot%20Fundamentals.pdf)
- Live coding: [spring-boot-intro](./live-coding/spring-boot-intro/)
- Start here (app entry): [SpringBootIntroApplication.java](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/SpringBootIntroApplication.java)
- Controller: [StudentController.java](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/controller/StudentController.java)

## Goal
Build the first real Spring Boot REST API shape for “students”: controller, service, repository, DTOs, and basic request/response behavior.

## Materials
- [Lecture PDF](./lecture/Lecture%2048_%20Module%204%20-%20Spring%20Boot%20Fundamentals.pdf)
- Live coding project: [spring-boot-intro](./live-coding/spring-boot-intro/)

## What we covered
- REST basics for a Student API (resource paths, methods, status codes)
- Spring MVC flow: Controller calls Service, Service calls Repository
- DTOs for request input
- Basic validations (annotations on DTO fields)

## Live coding
### Project: spring-boot-intro
- Port config: [application.properties](./live-coding/spring-boot-intro/src/main/resources/application.properties)
- API controller:
  - [StudentController.java](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/controller/StudentController.java)
- DTO:
  - [CreateStudentRequest.java](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/dto/CreateStudentRequest.java)
- Service and repo:
  - [StudentService.java](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/service/StudentService.java)
  - [StudentRepository.java](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/repo/StudentRepository.java)
  - [InMemoryStudentRepository.java](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/repo/InMemoryStudentRepository.java)

## API surface (what learners can call)
- GET `/students`
- GET `/students/{id}`
- POST `/students`

## Running and testing
- Run:
  - `./mvnw spring-boot:run`
- Test using a REST client (Postman recommended for Module 4).
