# Lecture 18 - Sliding Window and StringBuilder
Roadmap Day: TBD

Goal: Learn fixed-size sliding window and see why StringBuilder is faster than repeated concatenation.

## Materials
- Slides: [SDE_w__AI_Lecture_12.pdf](./lecture/SDE_w__AI_Lecture_12.pdf)
- Live coding: [lecture-18](./live-coding/lecture-18/)
- Problem set: [lecture-18-problem-set.md](./exercises/lecture-18-problem-set.md)
- Solutions: [lecture-18-problem-set-solutions.md](./exercises/lecture-18-problem-set-solutions.md)

## What we covered
- Fixed-size sliding window (sum of each window of size k)
- Optimizing window sum by reusing the previous window sum
- Maximum sum among all windows of size k
- Intro to variable-size window idea for unique substring tracking
- String concatenation vs StringBuilder append in a loop
- StringBuilder vs StringBuffer in a multi-threaded example

## Live coding
Location: [live-coding/lecture-18](./live-coding/lecture-18/)

Start here
- Inefficient window sum: [InEfficientSubarray.java](./live-coding/lecture-18/src/com/guvi/slidingwindow/InEfficientSubarray.java)
- Efficient window sum: [EfficientSlidingWindow.java](./live-coding/lecture-18/src/com/guvi/slidingwindow/EfficientSlidingWindow.java)
- Max window sum: [MaxOfKElements.java](./live-coding/lecture-18/src/com/guvi/slidingwindow/MaxOfKElements.java)
- Variable window starter: [VariableSlidingWindow.java](./live-coding/lecture-18/src/com/guvi/slidingwindow/VariableSlidingWindow.java)
- StringBuilder timing: [stringbuilder/Main.java](./live-coding/lecture-18/src/com/guvi/stringbuilder/Main.java)
- Builder vs Buffer threads: [BuilderVsBuffer.java](./live-coding/lecture-18/src/com/guvi/stringbuilder/BuilderVsBuffer.java)

## DSA tags
- Topic: Arrays, Strings
- Pattern: Sliding Window (fixed, variable)
