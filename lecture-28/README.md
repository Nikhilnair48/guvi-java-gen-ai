# Lecture 28 - Infix to Postfix Conversion and Evaluation
Roadmap Day: TBD

Goal: Convert an infix expression to postfix and evaluate it using a stack.

## Materials
- Live coding: [live-coding/lecture-28](./live-coding/lecture-28/)

## What we covered
- Tokenization assumptions for expression parsing (space-separated tokens)
- Operator precedence handling (+, -, *, /)
- Parentheses handling during conversion
- Evaluate postfix output using a stack

## Live coding
Location: [live-coding/lecture-28](./live-coding/lecture-28/)

Run
- Infix to postfix and evaluation demo: [InfixToPostfix.java](./live-coding/lecture-28/src/com/guvi/custom/problems/InfixToPostfix.java)
- Postfix evaluation helper: [PostfixEvaluator.java](./live-coding/lecture-28/src/com/guvi/custom/problems/PostfixEvaluator.java)

What to notice
- Precedence and parentheses logic lives here: [InfixToPostfix.java](./live-coding/lecture-28/src/com/guvi/custom/problems/InfixToPostfix.java)
- Postfix evaluation uses the custom stack: [PostfixEvaluator.java](./live-coding/lecture-28/src/com/guvi/custom/problems/PostfixEvaluator.java), [Stack.java](./live-coding/lecture-28/src/com/guvi/custom/stack/Stack.java)

## DSA tags
- Topic: Stack
- Pattern: Infix to postfix, Expression evaluation
