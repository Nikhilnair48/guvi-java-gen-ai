# Lecture 42 - MongoDB Part 2 (Indexes, Validation, Data Quality)
Roadmap Day: TBD

Goal: Learn how MongoDB handles duplicates by default, and how to enforce rules using indexes and validators.

## Materials
- Slides: [Lecture 42 - MongoDb Pt 2.pdf](./lecture/Lecture%2042%20-%20MongoDb%20Pt%202.pdf)
- Warmup: [mongodb-warmup.pdf](./lecture/mongodb-warmup.pdf)
- Live coding notes: [mongodb-notes.js](./live-coding/mongodb-notes.js)

## What we covered
- MongoDB uniqueness rules (only `_id` is unique by default)
- Creating a unique index to enforce uniqueness on another field (like email)
- Searching by non-_id fields and why indexing matters
- Collection validators to enforce required fields and basic schema checks

## Live coding
Location: [live-coding](./live-coding/)

Start here
- Notes and examples: [mongodb-notes.js](./live-coding/mongodb-notes.js)
