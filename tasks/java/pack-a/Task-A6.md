# Task A6 - Exception Handling: Registration Validator

### What this task is about
You will validate user registration input. Real systems validate fields and produce clear error messages. Your job is to enforce rules and raise a clear exception when something is wrong.

This task checks whether you understand:
- throwing exceptions
- creating custom exception classes
- using try/catch properly
- writing clear error messages

---

## What you need to build
Create two files:
- `UserRegistrationValidator.java`
- `ValidationException.java`

---

## Validation rules
You will validate three fields: email, age, and phone number.

### 1) Email rules
The email must:
- contain `@`
- contain `.`

If invalid, throw a `ValidationException` for field `"email"`.

### 2) Age rules
Age will be provided as a string (example: `"25"`). You must:
- confirm it contains only digits
- convert it to an integer
- confirm the number is between 13 and 120 (inclusive)

If invalid, throw a `ValidationException` for field `"age"`.

### 3) Phone rules
Phone must:
- be exactly 10 characters long
- contain only digits

If invalid, throw a `ValidationException` for field `"phone"`.

---

## Custom exception class: `ValidationException`
Your exception class must store:
- `field` (string)
- `reason` (string)
- `badValue` (string)

It must also build an error message like:
`Invalid <field>: <reason> (value=<badValue>)`

Example:
`Invalid age: must be a number between 13 and 120 (value=abc)`

---

## Validator class: `UserRegistrationValidator`
Create a method:

`public void validate(String email, String ageText, String phone) throws ValidationException`

**Purpose:** Validate all three fields. If any field fails validation, throw a `ValidationException` immediately with a clear reason.

---

## Required test cases (must be in main)

In `main()`, create at least 6 test cases and validate them. Use this exact pattern:

- If validation succeeds, print: `VALID`
- If validation fails, catch the exception and print the exception message

Include these specific test cases:
1) valid email, valid age, valid phone  
2) invalid email (missing `@`)  
3) invalid email (missing `.`)  
4) invalid age (contains letters)  
5) invalid age (below 13)  
6) invalid phone (not 10 digits)

---