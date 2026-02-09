# Lecture 40 - MySQL Part 2: CRUD, Data Types, Constraints
Roadmap Day: TBD

Goal: Practice the 5 core SQL verbs and introduce constraints with a better table design.

## Materials
- Slides: [Lecture 40 - MySQL Part 2.pdf](./lecture/Lecture%2040%20-%20MySQL%20Part%202.pdf)
- Warmups (present in this folder):
  - [activity-1-warmup.pdf](./lecture/activity-1-warmup.pdf)
  - [activity-2-warmup.pdf](./lecture/activity-2-warmup.pdf)
  - [activity-3-warmup.pdf](./lecture/activity-3-warmup.pdf)
- Live coding:
  - [students.sql](./live-coding/students.sql)
  - [students_v2.sql](./live-coding/students_v2.sql)

## What we covered
- CRUD flow in Workbench:
  - INSERT, SELECT, WHERE, UPDATE, DELETE
- Safe habit: SELECT first using the same WHERE you plan to UPDATE or DELETE
- Data types refresher (int, tinyint, varchar, text, boolean, timestamp)
- Constraints and defaults:
  - NOT NULL
  - UNIQUE
  - DEFAULT
  - AUTO_INCREMENT
  - CURRENT_TIMESTAMP

## Live coding
Files:
- Core CRUD demo: [students.sql](./live-coding/students.sql)
- Constraints and defaults table: [students_v2.sql](./live-coding/students_v2.sql)

What to notice
- `students.sql` includes:
  - database setup
  - table creation
  - sample inserts
  - filter queries
  - update by id
  - delete with conditions
- `students_v2.sql` introduces a stronger schema with constraints:
  - NOT NULL, UNIQUE, DEFAULT, created_at timestamp
