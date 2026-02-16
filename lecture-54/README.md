# Lecture 54 - Database Integrations Using MongoDB Atlas

## Goal
Set up MongoDB Atlas access from your laptop, connect using MongoDB Compass, and practice Atlas workflows (collections, filters, indexes, common connection fixes).

## Quick links
- Lecture PPTX: [Lecture 54 - Database Integrations using MongoDB Atlas](./lecture/Lecture%2054_%20Database%20Integrations%20using%20MongoDB%20Atlas.pptx)
- Live coding project: [spring-boot-intro](./live-coding/spring-boot-intro)
- Extra reference (hands-on notes): [MongoDB-indexing-references-embedded-objects](./live-coding/MongoDB-indexing-references-embedded-objects)

## What we covered
- Atlas basics: cluster, database, collections
- Getting the Compass connection string from Atlas
- Connecting MongoDB Compass to Atlas and navigating data
- Indexes in Compass and why they matter
- Common connection failures and quick fixes

## Live coding
### Project
- Folder: [live-coding/spring-boot-intro](./live-coding/spring-boot-intro)
- Entry point: [`SpringBootIntroApplication.java`](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/SpringBootIntroApplication.java)

### What to notice (key parts)
- Where the Mongo URI needs to be configured:
  - [`application.properties`](./live-coding/spring-boot-intro/src/main/resources/application.properties)
- Existing student API (list, search, paging):
  - [`StudentController.java`](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/controller/StudentController.java)
  - [`StudentService.java`](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/service/StudentService.java)
- Modeling additional collections (data modeling setup):
  - [`Course.java`](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/model/Course.java)
  - [`Enrollment.java`](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/model/Enrollment.java)
  - [`CourseRepository.java`](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/repo/CourseRepository.java)
  - [`EnrollmentRepository.java`](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/repo/EnrollmentRepository.java)

## Running and testing
- Open the project: `live-coding/spring-boot-intro`
- Configure your MongoDB URI in:
  - [`application.properties`](./live-coding/spring-boot-intro/src/main/resources/application.properties)
