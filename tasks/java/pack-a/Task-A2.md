# Task A2 - Method Surgeon: Build a Text Cleaning Utility

### What this task is about
When users enter text (names, short notes), the input often includes extra spaces. Also, substring operations can crash a program if the start/end values are invalid. You will build a small helper class that cleans text and extracts substrings safely.

This task checks whether you understand:
- methods with parameters and return values
- early returns for invalid inputs
- method overloading
- basic string operations

---

## What you need to build
Create a file named `TextTriage.java` with the methods below and a `main()` method to test them.

---

## Method 1: `trimAndCollapseSpaces(String input)`
**Purpose:** Clean a user-entered name or sentence so that it has no extra spaces.

Rules:
- If `input` is `null`, return `"INVALID"`.
- Remove leading and trailing spaces.
- Replace multiple spaces inside the text with a single space.
- If the input contains only spaces, trimming should result in an empty string `""`. That is allowed.

Examples:
- `"  Abdul   Kalam  "` -> `"Abdul Kalam"`
- `"   "` -> `""`
- `null` -> `"INVALID"`

---

## Method 2: `safeSubstring(String input, int start, int end)`
**Purpose:** Return a substring without crashing the program.

Rules:
- If `input` is `null`, return `"INVALID"`.
- If `start < 0`, return `"INVALID_RANGE"`.
- If `end > input.length()`, return `"INVALID_RANGE"`.
- If `start > end`, return `"INVALID_RANGE"`.
- Otherwise, return `input.substring(start, end)`.

---

## Method 3 (overload): `safeSubstring(String input, int start)`
**Purpose:** Return a substring from `start` to the end of the string, without crashing.

Rules:
- If `input` is `null`, return `"INVALID"`.
- If `start < 0` or `start > input.length()`, return `"INVALID_RANGE"`.
- Otherwise, return `input.substring(start)`.

---

## Required test cases (must be in main)

In `main()`, print outputs for these exact calls in this exact order:

1) `trimAndCollapseSpaces("  Abdul   Kalam  ")`  
2) `trimAndCollapseSpaces(null)`  
3) `safeSubstring("Bangalore", 0, 4)`  
4) `safeSubstring("Bangalore", -1, 4)`  
5) `safeSubstring("Bangalore", 3)`  
6) `safeSubstring("Bangalore", 20)`

Your program output must match exactly:
```
Abdul Kalam
INVALID
Bang
INVALID_RANGE
galore
INVALID_RANGE
```

---