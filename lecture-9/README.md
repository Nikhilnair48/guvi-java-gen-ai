# Lecture 9 - Collections Basics (List, Set, Iterator)
Roadmap Day: TBD

Goal: Use Java collections for dynamic storage and safe iteration.

## Materials
- Slides (present in this folder): [SDE_w__AI_Lecture_8.pdf](./lecture/SDE_w__AI_Lecture_8.pdf)
- Live coding: [live-coding/lecture-9](./live-coding/lecture-9/)

## What we covered
- List basics using ArrayList (add, get, size, insert at index)
- Set basics (uniqueness), HashSet vs LinkedHashSet
- Iterator usage and safe removal while iterating
- Small activity using an interface and LinkedHashSet for normalization

## Live coding
Location: [live-coding/lecture-9](./live-coding/lecture-9/)

Start here (pick one)
- ArrayList basics: [src/arraylist/Main.java](./live-coding/lecture-9/src/arraylist/Main.java)
- Iterator safe remove: [src/iterator/Main.java](./live-coding/lecture-9/src/iterator/Main.java)
- Set behavior: [src/set/Main.java](./live-coding/lecture-9/src/set/Main.java)
- Normalizer activity: [src/activity/two/Main.java](./live-coding/lecture-9/src/activity/two/Main.java)

What to notice
- Raw list usage requires casting when reading values
- LinkedHashSet keeps insertion order while removing duplicates
- Activity structure:
  - Interface: [Normalizer.java](./live-coding/lecture-9/src/activity/two/Normalizer.java)
  - Implementation: [TrimLower.java](./live-coding/lecture-9/src/activity/two/TrimLower.java)
