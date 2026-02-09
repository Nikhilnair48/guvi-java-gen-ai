# Lecture 39 - Introduction to MySQL
Roadmap Day: TBD

Goal: Understand MySQL basics and create the first database and table.

## Materials
- Slides: [SDE_ Lecture 39 - Intro to MySQL.pdf](./lecture/SDE_%20Lecture%2039%20-%20Intro%20to%20MySQL.pdf)
- Live coding: [live-coding/mysql-intro.sql](./live-coding/mysql-intro.sql)

## What we covered
- What MySQL is (RDBMS) and how tables store rows and columns
- Mental model: server (system), SQL (language), client tool (Workbench/CLI)
- SQL data types (numeric, text, dates, boolean)
- Schema basics (tables, columns, constraints)
- Create database, select database, create table with AUTO_INCREMENT primary key

## Live coding
File: [mysql-intro.sql](./live-coding/mysql-intro.sql)

What to notice
- Creates a database and a first table:
  - `CREATE DATABASE students;`
  - `CREATE TABLE learners (...)`
