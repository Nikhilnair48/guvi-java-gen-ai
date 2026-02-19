# Lecture 50: Database Integrations using MongoDB (Schema Design + API Query Rules)

## Quick links
- Lecture PDF: [Lecture 50 - Database Integrations using MongoDB](./lecture/Lecture%2050_%20Database%20Integrations%20using%20MongoDB.pdf)
- Live coding: [spring-boot-intro](./live-coding/spring-boot-intro/)
- Controller: [StudentController.java](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/controller/StudentController.java)
- Search response DTO: [StudentPageResponse.java](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/dto/StudentPageResponse.java)

## Goal
Lock down “real API behavior” for search, filters, sorting, and paging inputs. Then introduce MongoDB schema design mindset (document shape, embedding vs referencing, and constraints).

## Materials
- [Lecture PDF](./lecture/Lecture%2050_%20Database%20Integrations%20using%20MongoDB.pdf)
- Live coding project: [spring-boot-intro](./live-coding/spring-boot-intro/)

## What we covered
- Search API inputs as query parameters (name, email, active)
- Matching rules (case-insensitive contains for text filters; AND logic when multiple filters exist)
- Sorting inputs (sortBy, sortDir)
- Paging inputs (page, size) and response shape
- MongoDB schema design mindset:
  - baseline document shape for a Student
  - embedding vs referencing
  - uniqueness expectations for identity and email

## Live coding
### Project: spring-boot-intro
- Main API entry:
  - [StudentController.java](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/controller/StudentController.java)
- Search service entry:
  - [StudentService.java](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/service/StudentService.java)
- Response DTO:
  - [StudentPageResponse.java](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/dto/StudentPageResponse.java)

## API surface (what learners can call)
- GET `/students` with optional query parameters:
  - `name`, `email`, `active`, `sortBy`, `sortDir`, `page`, `size`
- GET `/students/{id}`
- POST `/students`
- PUT `/students/{id}`
- DELETE `/students/{id}`

## Running and testing
- Run:
  - `./mvnw spring-boot:run`
- Recommended: test endpoints using Postman (Module 4 standard).
