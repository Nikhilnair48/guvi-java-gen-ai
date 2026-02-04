# Lecture 11 - Generics, Lambdas, Comparator (Live Coding)
Roadmap Day: TBD

Goal: Use generics for type safety and write small lambda-based behaviors.

## Materials
- Slides (present in this folder): [SDE_w__AI_Lecture_10.pdf](./lecture/SDE_w__AI_Lecture_10.pdf)
- Live coding: [lecture-11](./live-coding/lecture-11/)

## What we covered
- Why generics exist and what goes wrong with raw types and casting
- Functional interfaces and lambdas
- Method reference basics
- Comparator with lambdas (sorting policy)

## Live coding
Location: [live-coding/lecture-11](./live-coding/lecture-11/)

Start here
- Lambda warmup (anonymous class vs lambda): [TaskRewrite.java](./live-coding/lecture-11/src/activity/TaskRewrite.java)
- Comparator and method reference: [comparator/Main.java](./live-coding/lecture-11/src/comparator/Main.java)

What to notice
- Generic cache example: [RawCache.java](./live-coding/lecture-11/src/warmup/cache/RawCache.java)
- Raw list pitfalls and casting failures: [PluginManagerLegacy.java](./live-coding/lecture-11/src/warmup/plugins/PluginManagerLegacy.java), [RequestHandlerLegacy.java](./live-coding/lecture-11/src/warmup/request/RequestHandlerLegacy.java)
- Wildcards and bounds example: [bounds/Main.java](./live-coding/lecture-11/src/bounds/Main.java)
- Lambda demo files: [lambda/Main.java](./live-coding/lecture-11/src/lambda/Main.java), [lambda/Main2.java](./live-coding/lecture-11/src/lambda/Main2.java), [lambda/Item.java](./live-coding/lecture-11/src/lambda/Item.java)
