# Lecture 46: Setting up Spring

## Quick links
- Lecture PDF: [Lecture 46 - Setting up Spring](./lecture/Lecture%2046_%20Setting%20up%20Spring.pdf)
- Live coding: [spring-boot-intro](./live-coding/spring-boot-intro/)
- Start here (app entry): [SpringBootIntroApplication.java](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/SpringBootIntroApplication.java)
- Config file: [application.properties](./live-coding/spring-boot-intro/src/main/resources/application.properties)

## Goal
Set up a Spring Boot project, understand the basic project structure, and get comfortable with ports, Maven, configuration, and the idea of an embedded server.

## Materials
- [Lecture PDF](./lecture/Lecture%2046_%20Setting%20up%20Spring.pdf)
- Live coding project: [spring-boot-intro](./live-coding/spring-boot-intro/)

## What we covered
- URL parts (host, port, path) and why ports matter for servers
- Maven basics and dependencies (what they do in a real project)
- Spring Boot project structure (where code, config, and tests live)
- Configuration changes using `application.properties`
- Embedded server concept (Tomcat as part of the app)

## Live coding
### Project: spring-boot-intro
- Entry point: [SpringBootIntroApplication.java](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/SpringBootIntroApplication.java)
- What to notice:
  - `@SpringBootApplication` as the app bootstrap
  - `CommandLineRunner` as a startup hook (run code after the app starts)
  - Constructor injection shape in services (no manual `new` inside services)
- Key classes:
  - Notifier: [Notifier.java](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/notify/Notifier.java), [ConsoleNotifier.java](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/notify/ConsoleNotifier.java)
  - Services: [StudentService.java](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/service/StudentService.java), [AttendanceService.java](./live-coding/spring-boot-intro/src/main/java/com/guvi/spring_boot_intro/service/AttendanceService.java)

## Running and testing
- Port config: [application.properties](./live-coding/spring-boot-intro/src/main/resources/application.properties)
- Typical run command (Maven wrapper):
  - `./mvnw spring-boot:run`
