# Lecture 14 - Annotations, Enums, and Localization
Roadmap Day: TBD

Goal: Use annotations, model fixed sets with enums, and load locale-based messages.

## Materials
- Slides: [SDE_w__AI_Lecture_11.pdf](./lecture/SDE_w__AI_Lecture_11.pdf)
- Live coding: [lecture-14](./live-coding/lecture-14/)

## What we covered
- Defining and reading custom annotations using reflection
- Enums for fixed sets and directional logic
- Localization with resource bundles and locale-specific property files

## Live coding
Location: [live-coding/lecture-14](./live-coding/lecture-14/)

Start here
- Annotations and reflection: [AnnotationProcessor.java](./live-coding/lecture-14/src/main/java/annotations/AnnotationProcessor.java)

What to notice
- Custom annotation definition: [Authenticated.java](./live-coding/lecture-14/src/main/java/annotations/Authenticated.java)
- Annotated method demo: [Demo.java](./live-coding/lecture-14/src/main/java/annotations/Demo.java)
- Enums examples: [Direction.java](./live-coding/lecture-14/src/main/java/enums/Direction.java), [Board.java](./live-coding/lecture-14/src/main/java/enums/Board.java)
- Localization demo: [LocaleDemo.java](./live-coding/lecture-14/src/main/java/locale/LocaleDemo.java)
- Message bundles:
  - [Messages.properties](./live-coding/lecture-14/src/main/resources/Messages.properties)
  - [Messages_en_US.properties](./live-coding/lecture-14/src/main/resources/Messages_en_US.properties)
  - [Messages_hi_IN.properties](./live-coding/lecture-14/src/main/resources/Messages_hi_IN.properties)
- Activity examples:
  - Badges and polymorphism: [ActivityOne.java](./live-coding/lecture-14/src/main/java/com/activity/one/ActivityOne.java)
  - Notification channels: [NotifyDemo.java](./live-coding/lecture-14/src/main/java/com/activity/two/NotifyDemo.java)
