# Lecture 36 - Graph Traversals and Connected Components
Roadmap Day: TBD

Goal: Traverse graphs using DFS and BFS, and count connected components in an undirected graph.

## Materials
- Live coding: [live-coding/lecture-36](./live-coding/lecture-36/)

## What we covered
- Graph representation using adjacency lists
- DFS traversal using recursion and a visited array
- BFS traversal using a queue and a visited array
- Counting connected components using repeated DFS (undirected graphs)
- Weighted graph representation using adjacency list of edges (to, weight)

## Live coding
Location: [live-coding/lecture-36](./live-coding/lecture-36/)

Start here
- DFS traversal demo (Graph): [Main.java](./live-coding/lecture-36/src/com/guvi/Main.java)

What to notice
- Adjacency-list graph + DFS + connected components:
  - [Graph.java](./live-coding/lecture-36/src/com/guvi/Graph.java)
- BFS traversal helper function (present in Main, currently not printed):
  - [Main.java](./live-coding/lecture-36/src/com/guvi/Main.java)
- Weighted graph adjacency list:
  - [WeightedGraph.java](./live-coding/lecture-36/src/com/guvi/WeightedGraph.java)
  - [Edge.java](./live-coding/lecture-36/src/com/guvi/Edge.java)
  - Runner: [WeightedGraphMain.java](./live-coding/lecture-36/src/com/guvi/WeightedGraphMain.java)

## DSA tags
- Topic: Graphs
- Pattern: DFS recursion, BFS queue, Connected components
