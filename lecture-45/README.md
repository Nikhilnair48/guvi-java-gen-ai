# Lecture 45 - Server Basics and Spring Intro (Student Mini Project)
Roadmap Day: TBD

Goal: Build a small Java CLI mini-project that sets up the need for DI/IoC before moving into Spring.

## Materials
- Slides: [Lecture 45_ Server + Spring Intro.pdf](./lecture/Lecture%2045_%20Server%20%2B%20Spring%20Intro.pdf)
- Live coding overview: [live-coding/README.md](./live-coding/README.md)

## What we covered
- Why we separate code into layers (model, repo, service)
- Using interfaces to decouple implementations (repository, notifier)
- Wiring dependencies in `main` (manual DI) as a stepping stone to IoC
- A small attendance flow built on top of a repository and service layer

## Live coding
Location: [live-coding](./live-coding/)

Projects
- Skeleton project shared with learners: [student-mini-project-skeleton/student-mini-project](./live-coding/student-mini-project-skeleton/student-mini-project/)
- Completed live-coded version: [student-mini-project](./live-coding/student-mini-project/)

Start here
- Entry point (completed project): [App.java](./live-coding/student-mini-project/src/main/java/com/guvi/module4/student/App.java)
- Entry point (skeleton): [App.java](./live-coding/student-mini-project-skeleton/student-mini-project/src/main/java/com/guvi/module4/student/App.java)

Key files (completed project)
- Model: [Student.java](./live-coding/student-mini-project/src/main/java/com/guvi/module4/student/model/Student.java)
- Repo interface + impl:
  - [StudentRepository.java](./live-coding/student-mini-project/src/main/java/com/guvi/module4/student/repo/StudentRepository.java)
  - [InMemoryStudentRepository.java](./live-coding/student-mini-project/src/main/java/com/guvi/module4/student/repo/InMemoryStudentRepository.java)
- Services:
  - [StudentService.java](./live-coding/student-mini-project/src/main/java/com/guvi/module4/student/service/StudentService.java)
  - [AttendanceService.java](./live-coding/student-mini-project/src/main/java/com/guvi/module4/student/service/AttendanceService.java)
- Notifications:
  - [Notifier.java](./live-coding/student-mini-project/src/main/java/com/guvi/module4/student/notify/Notifier.java)
  - [ConsoleNotifier.java](./live-coding/student-mini-project/src/main/java/com/guvi/module4/student/notify/ConsoleNotifier.java)

Run instructions
- See the project README: [student-mini-project/README.md](./live-coding/student-mini-project/README.md)
