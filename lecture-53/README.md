# Lecture 53 - Database Integrations Using MongoDB

## Goal
Enable listing and search for students using MongoDB, make index behavior visible using concrete examples, and start modeling courses and enrollments using references.

## Quick links
- Lecture PDF: [Lecture 53 - Database Integrations using MongoDB](./lecture/Lecture%2053_%20Database%20Integrations%20using%20MongoDB.pdf)
- Live coding project: [spring-boot-intro](./live-coding/spring-boot-intro)

## What we covered
- Listing students with pagination and sorting
- Search using a single query parameter (`q`) that can match name or email
- How derived query methods map to MongoDB queries
- Why indexes matter and what “unique index on email” actually enforces

## Live coding
### Project
- Folder: [live-coding/spring-boot-intro](./live-coding/spring-boot-intro)
- Entry point: [`SpringBootIntroApplication.java`](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/SpringBootIntroApplication.java)

### What to notice (key parts)
- Listing + search endpoint (pagination, sorting, q param logic):
  - [`StudentController.java`](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/controller/StudentController.java)
- Search logic and pageable construction:
  - [`StudentService.java`](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/service/StudentService.java)
- Derived query methods for search + filters:
  - [`StudentRepository.java`](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/repo/StudentRepository.java)
- Response wrapper for list endpoints:
  - [`StudentPageResponseV2.java`](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/dto/StudentPageResponseV2.java)
- MongoDB config:
  - [`application.properties`](./live-coding/spring-boot-intro/src/main/resources/application.properties)

## Running and testing
- Open the project: `live-coding/spring-boot-intro`
- Ensure MongoDB is reachable using the URI configured in:
  - [`application.properties`](./live-coding/spring-boot-intro/src/main/resources/application.properties)
