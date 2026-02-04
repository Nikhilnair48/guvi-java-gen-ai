# Lecture 12 - File I/O and Threads
Roadmap Day: TBD

Goal: Read and write files using NIO and understand basic threading primitives.

## Materials
- Slides (present in this folder): [SDE_w__AI_Lecture_10.pdf](./lecture/SDE_w__AI_Lecture_10.pdf)
- Live coding: [lecture-12](./live-coding/lecture-12/)

## What we covered
- Reading and writing text files using `Files.readString` and `Files.writeString`
- Normalizing file content (trim, remove blanks, dedupe, preserve order)
- Creating and running threads using `Runnable` and `Thread`
- Join vs sleep and basic thread lifecycle ideas

## Live coding
Location: [live-coding/lecture-12](./live-coding/lecture-12/)

Start here
- File I/O activity: [ToDo.java](./live-coding/lecture-12/src/com/guvi/activity/ToDo.java)
- Threads intro: [Intro.java](./live-coding/lecture-12/src/com/guvi/concurrency/threads/Intro.java)

What to notice
- File I/O uses the sample file: [data/todo.txt](./live-coding/lecture-12/data/todo.txt)
- Alternate activity version: [ToDoWithComments.java](./live-coding/lecture-12/src/com/guvi/activity/ToDoWithComments.java)
- Thread examples: [ThreadExample.java](./live-coding/lecture-12/src/com/guvi/concurrency/threads/ThreadExample.java), [ReusableTask.java](./live-coding/lecture-12/src/com/guvi/concurrency/threads/ReusableTask.java)
- Join vs sleep: [JoinVsSleep.java](./live-coding/lecture-12/src/com/guvi/concurrency/threads/JoinVsSleep.java)
- Lambda review helpers: [Review.java](./live-coding/lecture-12/src/com/guvi/lambda/Review.java), [Printer.java](./live-coding/lecture-12/src/com/guvi/lambda/Printer.java), [IPrint.java](./live-coding/lecture-12/src/com/guvi/lambda/IPrint.java), [IPrintTwo.java](./live-coding/lecture-12/src/com/guvi/lambda/IPrintTwo.java)
