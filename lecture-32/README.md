# Lecture 32 - Tree Reconstruction and BST Skeleton
Roadmap Day: TBD

Goal: Rebuild a binary tree from traversal outputs and introduce BST operations.

## Materials
- Live coding: [live-coding/lecture-32/lecture-32](./live-coding/lecture-32/lecture-32/)

## What we covered
- Tree traversals (DFS) to generate traversal lists
- Reconstruct a tree from preorder + inorder
  - Use a HashMap to store inorder indexes
  - Use a moving preorder index to pick roots in order
- BST concepts (generic skeleton using Comparator)
  - contains (search)
  - insert
  - delete (cases: leaf, one child, two children using inorder successor idea)

## Live coding
Location: [live-coding/lecture-32/lecture-32](./live-coding/lecture-32/lecture-32/)

Start here
- Build traversals and reconstruct tree: [Main.java](./live-coding/lecture-32/lecture-32/src/com/guvi/Main.java)

Key files
- Tree reconstruction helpers are in: [Main.java](./live-coding/lecture-32/lecture-32/src/com/guvi/Main.java)
- Generic BST skeleton: [BinarySearchTree.java](./live-coding/lecture-32/lecture-32/src/com/guvi/BinarySearchTree.java)
- Generic tree node used by BST: [TreeNodeGeneric.java](./live-coding/lecture-32/lecture-32/src/com/guvi/TreeNodeGeneric.java)

## DSA tags
- Topic: Trees, BST
- Pattern: Recursion, HashMap index lookup
