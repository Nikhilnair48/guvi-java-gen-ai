# Task A4 - Package Postcard: Mini Project Structure and Access Checks

### What this task is about
Packages are used to organize code and control visibility. In real projects, not every class is meant to be used from everywhere. Some classes are internal to a package, and some classes are utility-only and should not be instantiated.

This task checks whether you understand package declarations, imports, fully qualified names, and basic access rules.

---

## Folder and package structure (must match exactly)

Create the following files under `src/`:

```
src/
  com/app/main/Main.java
  com/app/text/TextTriage.java
  com/app/device/Thermostat.java
  com/app/text/InternalTextRules.java
  com/app/text/TextConstants.java
```

Each file must begin with the correct `package` line so the folder structure matches the package name.

---

## Main.java requirements (imports and one fully qualified call)

In `Main.java`:

1) Use `import` statements to use `TextTriage` and `Thermostat`.  
2) Make exactly one method call using a fully qualified class name (no import). For example:  
   `com.app.text.TextTriage.safeSubstring("Bangalore", 0, 4);`

---

## Access check 1: Package-private class

Create `InternalTextRules` inside package `com.app.text`.

This class must be package-private, so do not write `public` in the class declaration.

Inside `InternalTextRules`, add a helper method:

- Method name: `isValidRange(String input, int start, int end)`  
- Purpose: Return `true` only if substring parameters are safe; otherwise return `false`.

Now open `Main.java` and add this line exactly:

```java
InternalTextRules rules = new InternalTextRules();
```

Directly above that line, write a comment explaining why this line cannot compile (2–3 sentences is enough). Then comment out the line so your project can compile and run.

---

## Access check 2: Utility class that cannot be instantiated

Create `TextConstants` inside package `com.app.text`.

This class must store two string constants used by `TextTriage`:
- `INVALID`
- `INVALID_RANGE`

Write them as `public static final` constants. Prevent object creation by adding a private constructor.

Now open `Main.java` and add this line exactly:

```java
TextConstants constants = new TextConstants();
```

Directly above that line, write a comment explaining why this line cannot compile (2–3 sentences is enough). Then comment out the line so your project can compile and run.

---

## Run requirements

When you run `Main`, it must do both of the following:

1) Run the Task A2 demo calls for `TextTriage` (the six test calls from Task A2).  
2) Run a short thermostat demo:
   - Create a thermostat  
   - Set mode to `"HEAT"`  
   - Call `tick()` three times  
   - Print `status()`

---