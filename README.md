# SDE with AI: Java Module

This repository contains the Java module from the broader SDE with AI program.  
It is designed for learners who want to build a solid foundation in programming through hands-on reasoning and progressive problem-solving.  
Each lecture introduces one or two key ideas and builds on what was covered earlier, supported by live coding, notes, and exercises.

## Course Overview

The course moves from programming fundamentals to advanced Java concepts.  
It focuses on writing clear, correct, and maintainable code.  
Each lecture connects a problem to its solution; the learner explores why the problem exists, what approaches can solve it, and how Java’s language features fit that reasoning.

Each lecture includes:

* Notes that explain the underlying idea and how it fits into the bigger picture.
* Live coding examples that demonstrate those ideas in action.
* Exercises that help the learner practice and internalize the concepts.

## Module Map

| Module                              | Focus                     | Key Skills                               | Outcome                                 |
| ----------------------------------- | ------------------------- | ---------------------------------------- | --------------------------------------- |
| 1. Programming Foundations (Java)   | Syntax, Control Flow, OOP | Variables, Loops, Classes, Encapsulation | Write structured, readable Java code    |
| 2. Data Structures & Algorithms     | Core DSA patterns         | Arrays, Lists, Stacks, Trees, Graphs     | Develop problem-solving discipline      |
| 3. Databases                        | SQL and NoSQL design      | MySQL, MongoDB, Joins, Indexing          | Design and query data efficiently       |
| 4. Backend with Spring Boot & Kafka | Scalable backend systems  | REST APIs, Kafka events                  | Build reliable backend services         |
| 5. System Design                    | Architecture principles   | HLD, LLD, Caching, Sharding              | Design maintainable backend systems     |
| 6–8. Frontend Foundations           | UI Engineering            | HTML, CSS, JS, React                     | Build interactive web interfaces        |
| 9. DevOps for Developers            | Deployment and pipelines  | GitHub Actions, AWS, Docker              | Automate builds and deploy applications |
| 10. Spring Boot + GenAI             | AI integration            | RAG, Vector Search, LLM APIs             | Extend backend systems with AI features |

## Repository Overview

The repository is organized into folders named `lecture-1` through `lecture-N` where `N` is the lastest lecture folder.

Each folder contains:

- `lecture-XX/`
  - `lecture/` -> slide deck / PDF used in class
  - `live-coding/` -> code written during the session
  - `exercises/` -> practice tasks (when present)

All lectures align with the official course curriculum. Some topics span multiple sessions, and others combine due to pacing or doubt sessions.

## Helpful Documents
- Learning Path
    - [PDF](https://github.com/Nikhilnair48/guvi-java-gen-ai/blob/main/Learning-Path-SDE-with-AI.pdf)
    - [Excel Workbook](https://github.com/Nikhilnair48/guvi-java-gen-ai/blob/main/Learning-Path-SDE-with-AI.xlsx)
- Zen SDE with AI
    - [PDF](https://github.com/Nikhilnair48/guvi-java-gen-ai/blob/main/Zen-SDE-with-AI.pdf)

## Curriculum mapping

The sessions don't always follow the learning paths' roadmap. The table below provides a mapping from the roadmap day in the learning path to the folders in this repository.

| Roadmap Day | Topic | Repository Folders | Lecture Date (YYYY-MM-DD) | Doubt Session | Exercises |
|---:|---|---|---|---|---|
| 1 | Introduction to Java & Setup | [lecture-1](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-1) | 2025-09-26 | No | [Exercises](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-1/exercises) |
| 2 | Control Flow, Loops & Methods in Java | [lecture-2](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-2), [lecture-3](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-3) | 2025-09-27, 2025-09-28 | No | [Exercises](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-2/exercises), [Exercises](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-3/exercises) |
| 3 | Arrays, String API & Wrapper Classes | [lecture-4](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-4), [lecture-5](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-5) | 2025-10-03, 2025-10-04 | Yes (Partial) | [Exercises](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-4/exercises), [Exercises](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-5/exercises) |
| 4 | Intro to OOP: Classes & Objects and OOP Features | [lecture-6](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-6) | 2025-10-05 | No | [Exercises](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-6/exercises) |
| 5 | Core OOP: Polymorphism, Abstraction, Interfaces & Packages | [lecture-7](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-7) | 2025-10-10 | No | [Exercises](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-7/exercises) |
| 6 | Exception Handling | [lecture-8](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-8) | 2025-11-11 | No | [Exercises](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-8/exercises) |
| 7 | Collections Framework | [lecture-9](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-9), [lecture-10](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-10) | 2025-11-12, 2025-11-17 | Yes (Partial) | [Exercises](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-9/exercises), [Exercises](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-10/exercises) |
| 8 | Generics & Lambda Expressions | [lecture-10](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-10), [lecture-11](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-11) | 2025-11-18 | No | [Exercises](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-10/exercises), [Exercises](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-11/exercises) |
| 9 | File I/O & Concurrency | [lecture-11](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-11), [lecture-12](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-12) | 2025-11-18, 2025-11-24 | No | [Exercises](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-11/exercises), [Exercises](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-12/exercises) |
| 10 | Java Advanced Topics & Features | [lecture-13](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-13), [lecture-14](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-14) | 2025-11-25, 2025-11-31 | Yes (Partial) | [Exercises](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-13/exercises), [Exercises](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-14/exercises) |
| 11 | Introduction to DSA (taught by another instructor; no repo folder) | — | 2025-10-26 | No | — |
| 12 | Arrays and Strings | [lecture-16](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-16) | 2025-11-02 | No | — |
| 13 | Recursion and Backtracking | [lecture-17](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-17) | 2025-11-07 | No | — |
| 14 | Practice Session | [lecture-18](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-18) | 2025-11-08 | No | [Exercises](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-18/exercises) |
| 15 | Searching and Sorting | [lecture-19](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-19) | 2025-11-09 | No | [Exercises](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-19/exercises) |
| 16 | Searching and Sorting (continued) | [lecture-19](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-19) | 2025-11-09 | No | [Exercises](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-19/exercises) |
| 17 | Practice Session | [lecture-20](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-20) | 2025-11-14 | No | [Exercises](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-20/exercises) |
| 18 | Linked Lists | [lecture-21](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-21) | 2025-11-15 | No | — |
| 19 | Stacks and Queues | [lecture-22](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-22), [lecture-28](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-28) | 2025-11-16, 2025-12-06 | No | — |
| 20 | Practice Session | [lecture-23](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-23) | 2025-11-21 | No | — |
| 21 | Hashing | [lecture-24](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-24), [lecture-29](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-29) | 2025-11-22, 2025-12-07 | No | — |
| 22 | Trees and Binary Trees | [lecture-25](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-25) | 2025-11-23 | No | — |
| 23 | Binary Search Trees (BST) | [lecture-26](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-26) | 2025-11-29 | No | — |
| 24 | Heaps and Priority Queues | [lecture-27](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-27) | 2025-11-30 | No | — |
| 25 | Practice Session | [lecture-30](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-30) | 2025-12-12 | No | — |
| 26 | Graphs | [lecture-31](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-31) | 2025-12-13 | No | — |
| 27 | Greedy Algorithms | [lecture-32](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-32), [lecture-34](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-34), [lecture-36](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-36) | 2025-12-14, 2025-12-20, 2025-12-26 | No | — |
| 28 | Practice Session + Wrap-up | [lecture-33](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-33), [lecture-35](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-35), [lecture-37](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-37) | 2025-12-19, 2025-12-21, 2025-12-27 | No | — |
| 28A | Extra: LeetCode Support | [lecture-43](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-43) | 2026-01-10 | No | — |
| 28B | Extra: LeetCode Support | [lecture-44](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-44) | 2026-01-11 | No | — |
| 28C | Extra: DSA Doubts + LeetCode Review | [lecture-57](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-57) | 2026-02-13 | Yes | — |
| 29 | Database Introduction | [lecture-38](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-38) | 2025-12-28 | No | — |
| 30 | MySQL | [lecture-39](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-39), [lecture-40](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-40) | 2026-01-02, 2026-01-03 | No | — |
| 31 | MongoDB | [lecture-41](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-41) | 2026-01-04 | No | — |
| 32 | MongoDB (Pt 2) | [lecture-42](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-42) | 2026-01-09 | No | — |
| 33 | SQLKATA (self-practice assigned during MongoDB sessions) | [lecture-42](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-42) | 2026-01-09 | No | — |
| 34 | Getting started with Spring & Spring Boot | [lecture-45](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-45) | 2026-01-16 | No | — |
| 35 | Spring Boot Project Setup & Configuration | [lecture-46](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-46) | 2026-01-17 | No | — |
| 36 | Developing RESTful APIs with Spring Boot | [lecture-47](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-47) | 2026-01-18 | No | — |
| 37 | API Request Handling, Validation & Error Management | [lecture-48](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-48) | 2026-01-23 | No | — |
| 38 | Search, Filtering & Pagination in REST APIs | [lecture-49](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-49) | 2026-01-24 | No | — |
| 39 | MongoDB Data Modeling and Schema Design | [lecture-50](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-50) | 2026-01-25 | No | — |
| 40 | Connecting to MongoDB in Java Spring Boot Applications | [lecture-51](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-51) | 2026-01-30 | No | — |
| 41 | Spring Boot + MongoDB CRUD Operations | [lecture-52](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-52) | 2026-01-31 | No | — |
| 42 | MongoDB CRUD: Modifying Query Results | [lecture-53](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-53) | 2026-02-01 | No | — |
| 43 | Database Integrations using MongoDB | [lecture-54](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-54) | 2026-02-06 | No | — |
| 44 | Authentication and Security - 1 | [lecture-55](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-55) | 2026-02-07 | No | — |
| 45 | Authentication and Security - 2 | [lecture-56](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-56) | 2026-02-08 | No | — |
| 46 | Testing & Documentation | [lecture-58](https://github.com/Nikhilnair48/guvi-java-gen-ai/tree/main/lecture-58) | 2026-02-15 | No | — |

### Notes on “extra” sessions

- `28A` / `28B`: LeetCode practice support sessions to help learners with the 100 Leetcode Problems challenge.
- `28C`: DSA doubts + LeetCode review session to learners.

## Learning Experience

Each lecture connects a conceptual idea to its implementation. The process follows a steady rhythm:

1. Introduce a problem that mirrors something real.  
2. Explore how Java provides tools to address that problem.  
3. Build a working example, test it, and refine it.  
4. Reflect briefly on why this approach works better than alternatives.

| Component     | Purpose                                                      |
| ------------- | ------------------------------------------------------------ |
| Lecture Notes | Explain the concept and its role in the larger system.       |
| Live Coding   | Demonstrate the step-by-step reasoning through code.         |
| Exercises     | Strengthen understanding by applying concepts independently. |

The goal is not to rush through content but to make learners comfortable reading, reasoning about, and improving code.

## Setup Instructions

**Prerequisites:**

* Java 21 or a compatible version  
* IntelliJ IDEA, VS Code, or any Java IDE  
* Basic familiarity with command-line tools  

**Clone and run:**

```
git clone https://github.com/nikhilnair48/guvi-java-gen-ai.git
cd guvi-java-gen-ai/lecture-1/live-coding/hello-world
javac App.java
java App
```

## For Mentors and Contributors

If you are teaching or contributing:

* Follow the Zen Mentor Guidelines.  
* Maintain one `lecture/`, `live-coding/`, and `exercises/` subfolder per lecture.  
* Use clear commit messages such as `feat: lecture 5 exercises` or `fix: typo in lecture notes`.  

## License

This repository is licensed under the MIT License.  
See the [LICENSE](https://github.com/Nikhilnair48/guvi-java-gen-ai/blob/main/LICENSE) file for details.