# Task A5 - Password Referee

### What this task is about
You will write a small program that checks a password and gives it a score and a verdict. Many real applications do basic password checks before allowing users to register. Your job is to implement clear rules and produce consistent output.

This task checks whether you understand:
- working with strings and characters
- loops and conditions
- using `Character.isUpperCase`, `Character.isLowerCase`, and `Character.isDigit`
- writing clean, testable logic

---

## What you need to build
Create a file named `PasswordReferee.java`.

Inside it, create:
1) A class named `PasswordReferee`
2) A helper class (or record) named `PasswordResult` that stores:
   - `score` (integer)
   - `verdict` (string)
   - `reasons` (array of strings, size 3)

---

## Method to implement: `evaluate(String password)`
**Purpose:** Examine the password, calculate a score (0–100), decide a verdict, and return a `PasswordResult`.

### Step 1: Start score at 0
Set `score = 0`.

### Step 2: Add points for length (maximum 30 points)
- If length < 6 -> add 0
- If length is 6–8 -> add 10
- If length is 9–12 -> add 20
- If length is 13 or more -> add 30

### Step 3: Add points for character variety (maximum 40 points)
Add 10 points for each of the following that the password contains:
- at least one lowercase letter
- at least one uppercase letter
- at least one digit
- at least one symbol (a character that is not a letter or digit)

### Step 4: Apply penalties (up to 40 points can be removed)
Subtract points based on these rules:

1) If the password contains the name `"abdul"` or `"kalam"` (case-insensitive), subtract 20 points.  
2) If any character repeats 3 or more times in a row, subtract 10 points.  
3) If the password contains 4 digits in a row, subtract 10 points.  

---

## Score limits
After adding points and applying penalties:
- If the score becomes less than 0, set it to 0.
- If the score becomes more than 100, set it to 100.

---

## Verdict rules
Decide the verdict based on the final score:
- 0 to 39 -> `"WEAK"`
- 40 to 69 -> `"OK"`
- 70 to 100 -> `"STRONG"`

---

## Reasons (top 3)
Your `PasswordResult` must include exactly 3 reason strings describing the most important findings. Use simple sentences like:
- `"Good length"`
- `"Has uppercase and lowercase letters"`
- `"Contains 4 digits in a row"`
- `"Contains repeated characters"`
- `"Contains the name abdul/kalam"`

If fewer than 3 reasons apply, fill remaining slots with `"No additional notes"`.

---

## Required test cases (must be in main)

In `main()`, call `evaluate(...)` on these exact passwords and print the results:

1) `"abdul1234"`  
2) `"Aa1!aaaa"`  
3) `"GoodPass1!"`  
4) `"kalam!!"`  

---

## Required output format
For each password, print exactly these four lines, then print one blank line:

```
Password: <password>
Score: <score>
Verdict: <verdict>
Reasons: <reason1> | <reason2> | <reason3>
```

---

## Must-use requirements
- Use `Character.isUpperCase`, `Character.isLowerCase`, and `Character.isDigit`.
- Use a loop to scan the password character-by-character.
- Do not use regular expressions for the entire solution. The main logic must be loop-based.

---