# Task A3 - Class Anatomy: Smart Thermostat Simulator

### What this task is about
You will build a small thermostat simulation. A thermostat stores the current room temperature, a target temperature, and a mode that decides whether the temperature should increase, decrease, or remain unchanged over time.

This task is designed to check whether you can create a class with private instance variables, constructors, and instance methods that update object state.

---

## What you need to build

### 1) Create a class named `Thermostat`
Your `Thermostat` class must store **three private instance variables**:

- `currentTemp` (integer): the current room temperature  
- `targetTemp` (integer): the temperature the user wants  
- `mode` (string): one of `"HEAT"`, `"COOL"`, or `"OFF"`

---

### 2) Add two constructors

#### a) Default constructor  
**Purpose:** Create a thermostat in a safe default state.

When created using the default constructor:
- `currentTemp` must be 24  
- `targetTemp` must be 24  
- `mode` must be `"OFF"`

#### b) Constructor with inputs  
**Purpose:** Create a thermostat with starting values while keeping the object valid.

This constructor must accept three inputs: starting current temperature, starting target temperature, and starting mode.

Validation rules:
- Temperatures must be between **16 and 30** (inclusive). If an input temperature is outside this range, set it to 24.  
- Mode must be exactly `"HEAT"`, `"COOL"`, or `"OFF"`. If the input is invalid, set it to `"OFF"`.

---

### 3) Add these instance methods

#### a) `setMode(String mode)`  
**Purpose:** Change the thermostat mode safely.

Rules:
- If the input is `"HEAT"`, `"COOL"`, or `"OFF"`, update the mode.  
- Otherwise, do not change the mode.

#### b) `setTargetTemp(int targetTemp)`  
**Purpose:** Change the target temperature safely.

Rules:
- If the input is between 16 and 30 (inclusive), update the target temperature.  
- Otherwise, do not change the target temperature.

#### c) `tick()`  
**Purpose:** Simulate one minute passing. In one minute, the temperature may move by 1 degree toward the target depending on the mode.

Rules:
- If mode is `"HEAT"` and `currentTemp` is less than `targetTemp`, increase `currentTemp` by 1.  
- If mode is `"COOL"` and `currentTemp` is greater than `targetTemp`, decrease `currentTemp` by 1.  
- If mode is `"OFF"`, do not change `currentTemp`.  
- If the temperature is already equal to the target, do not change it.

#### d) `status()`  
**Purpose:** Return a readable summary of the thermostat state.

Return a string exactly in this format:  
`Mode=<mode>, Current=<currentTemp>, Target=<targetTemp>`

Example:  
`Mode=HEAT, Current=25, Target=28`

---

## Required testing

### Create a separate file named `ThermostatDemo.java`
Your demo must follow the steps below in this exact order. Print `status()` after each required stage so we can verify the behavior.

1) Create a thermostat using the default constructor, then print `status()`.  
2) Set mode to `"OFF"`, set target temperature to 28, call `tick()` 3 times, then print `status()`.  
3) Set mode to `"HEAT"`, set target temperature to 28, call `tick()` 5 times, then print `status()`.  
4) Set mode to `"COOL"`, set target temperature to 22, call `tick()` 10 times, then print `status()`.  
5) Call `setTargetTemp(100)` and `setMode("WARM")`, then print `status()` again to show that invalid inputs do not change the thermostat state.

---