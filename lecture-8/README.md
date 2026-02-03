# Lecture 8 - Exception Handling (try, catch, finally)
Roadmap Day: TBD

Goal: Handle runtime errors safely using exceptions.

## Materials
- Slides (present in this folder): [SDE_w__AI_Lecture_7.pdf](./lecture/SDE_w__AI_Lecture_7.pdf)
- Live coding: [live-coding/lecture-8](./live-coding/lecture-8/)

## What we covered
- Common runtime exceptions (null, number format)
- Throwing exceptions for validation failures
- try, catch, finally flow
- Multi-catch and wrapping exceptions with a cause

## Live coding
Location: [live-coding/lecture-8](./live-coding/lecture-8/)

Start here
- [src/com/guvi/exceptions/Main.java](./live-coding/lecture-8/src/com/guvi/exceptions/Main.java)

What to notice
- Throwing `IllegalArgumentException` for invalid inputs
- try/catch/finally return behavior in a method
- Multi-catch example: [MultiCatch.java](./live-coding/lecture-8/src/com/guvi/exceptions/MultiCatch.java)
- Custom exception stub (placeholder): [InsufficientBalanceException.java](./live-coding/lecture-8/src/com/guvi/exceptions/InsufficientBalanceException.java)
