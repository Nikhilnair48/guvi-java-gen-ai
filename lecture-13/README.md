# Lecture 13 - Java Advanced Topics and Features
Roadmap Day: TBD

Goal: Understand memory basics and use modern Java language features in small examples.

## Materials
- Slides: [SDE_w__AI_Lecture_11.pdf](./lecture/SDE_w__AI_Lecture_11.pdf)
- Live coding: [lecture-13](./live-coding/lecture-13/)

## What we covered
- Memory concepts (stack vs heap) and why references matter
- GC and how accidental retention can cause memory growth
- Modern Java features used in real code: var, text blocks, records, sealed types
- Thread basics via small examples

## Live coding
Location: [live-coding/lecture-13](./live-coding/lecture-13/)

Start here
- Modern Java features:
  - var: [VarUsage.java](./live-coding/lecture-13/src/com/modern/VarUsage.java)
  - text blocks: [TextBlock.java](./live-coding/lecture-13/src/com/modern/TextBlock.java)
  - records: [RecordDemo.java](./live-coding/lecture-13/src/com/modern/RecordDemo.java)
  - sealed types: [SealedArea.java](./live-coding/lecture-13/src/com/modern/SealedArea.java)

What to notice
- Memory retention examples: [MemoryCheck.java](./live-coding/lecture-13/src/com/activity/one/MemoryCheck.java)
- GC and retention demo: [LeakDemo.java](./live-coding/lecture-13/src/com/gc/LeakDemo.java)
- Thread examples (incremental demos): [ThreadExample1.java](./live-coding/lecture-13/src/com/guvi/concurrency/ThreadExample1.java) through [ThreadExample10.java](./live-coding/lecture-13/src/com/guvi/concurrency/ThreadExample10.java)
