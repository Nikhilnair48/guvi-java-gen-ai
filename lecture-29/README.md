# Lecture 29 - Hashing: equals, hashCode, and a Custom HashMap
Roadmap Day: TBD

Goal: Understand hashing basics and how hash-based maps work internally.

## Materials
- Live coding: [live-coding/lecture-29](./live-coding/lecture-29/)

## What we covered
- Why equals and hashCode must be consistent for hash-based collections
- Using a custom object as a HashMap key
- Building a custom HashMap (buckets + chaining) with generics
- Operations implemented: put, get, size, isEmpty, containsKey

## Live coding
Location: [live-coding/lecture-29](./live-coding/lecture-29/)

Run
- equals/hashCode with Java HashMap: [Main.java](./live-coding/lecture-29/src/com/guvi/Main.java)

What to notice
- Key object with equals and hashCode: [Student.java](./live-coding/lecture-29/src/com/guvi/Student.java)
- Custom HashMap implementation: [CustomHashMap.java](./live-coding/lecture-29/src/com/guvi/CustomHashMap.java)

## DSA tags
- Topic: Hashing
- Pattern: Buckets and chaining
