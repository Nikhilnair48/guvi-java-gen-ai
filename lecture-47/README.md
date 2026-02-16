# Lecture 47: Spring Recap and REST APIs (Mental Model First)

## Quick links
- Lecture PDF: [Lecture 47 - Spring Recap + RESTful APIs](./lecture/Lecture%2047_%20Spring%20Recap%20%2B%20RESTful%20APIs%20_w%20Boot.pdf)
- Live coding: [tinycontainer-warmup](./live-coding/tinycontainer-warmup/)
- Start here (warmup main): [AppMain.java](./live-coding/tinycontainer-warmup/src/main/java/com/guvi/module4/student/main/AppMain.java)
- Warmup project README: [tinycontainer-warmup/README.md](./live-coding/tinycontainer-warmup/README.md)

## Goal
Make Spring feel non-magical by understanding the framework mental model: registration, dependency wiring, lifecycle hooks, and startup flow. Then connect that to how Spring Boot runs backend server apps.

## Materials
- [Lecture PDF](./lecture/Lecture%2047_%20Spring%20Recap%20%2B%20RESTful%20APIs%20_w%20Boot.pdf)
- Live coding warmup: [tinycontainer-warmup](./live-coding/tinycontainer-warmup/)

## What we covered
- Framework vs library (who calls whom)
- Inversion of Control (IoC) and why containers exist
- How “beans” are created, wired, stored, and reused
- Lifecycle idea (init hooks) and “startup tasks”

## Live coding
### Project: tinycontainer-warmup
- Start here: [AppMain.java](./live-coding/tinycontainer-warmup/src/main/java/com/guvi/module4/student/main/AppMain.java)
- What to notice:
  - The container builds objects by resolving constructor dependencies
  - Container phases (definitions, instances, init, startup tasks, reporting)
- Container core:
  - [TinyContainer.java](./live-coding/tinycontainer-warmup/src/main/java/com/guvi/module4/tinyframework/container/TinyContainer.java)
  - [DefinitionRegistry.java](./live-coding/tinycontainer-warmup/src/main/java/com/guvi/module4/tinyframework/container/DefinitionRegistry.java)
  - [InstanceRegistry.java](./live-coding/tinycontainer-warmup/src/main/java/com/guvi/module4/tinyframework/container/InstanceRegistry.java)

## Running
- Terminal: follow [tinycontainer-warmup/README.md](./live-coding/tinycontainer-warmup/README.md)
- Script: [run.sh](./live-coding/tinycontainer-warmup/run.sh)
