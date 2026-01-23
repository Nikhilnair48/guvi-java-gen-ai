# Task A1 - Variable Detective: Fix the Story Generator

### What this task is about
You are given a Java program that is supposed to print a short “delivery story” for a customer. The file currently does **not compile**. Your job is to fix it so that it compiles and runs correctly.

This task checks whether you understand:
- variables (declaration vs initialization vs assignment)
- object creation using `new`
- scope (where a variable can be used)
- `final` variables
- static vs non-static basics
- method return types

---

## What you need to do

1) Create a file named `StoryGenerator.java`.  
2) Copy the starter code below into the file.  
3) Fix the code until it compiles.  
4) Run it and confirm it prints a story output.  
5) Add short comments above **any five lines you changed**, explaining what you changed and why.

---

## The problems you must fix

The starter code contains **10 compile-time problems**. Fix all of them.

1) A `final` instance variable is declared but never assigned.  
2) A local variable is used before it is given a value.  
3) A decimal number is assigned to an `int`.  
4) A constructor is written incorrectly, so Java treats it as a normal method.  
5) A method tries to return a value even though it is declared as `void`.  
6) A variable is declared inside an `if` block and used outside the block.  
7) A variable is declared twice in the same scope.  
8) A wrong variable name is used (spelling mistake).  
9) An object is created incorrectly (object creation should use `new`).  
10) A non-static method is called from a static context incorrectly.

---

## Starter code

```java
public class StoryGenerator {

    final int orderId; // Problem: final field is never assigned

    String destination = "MG Road";

    // Problem: decimal assigned to int
    int distanceKm = 7.5;

    // Problem: this is not a constructor because it has a return type (void)
    public void StoryGenerator(int id) {
        orderId = id;
    }

    static double calculateCharge(int distanceKm) {
        double base = 20;
        double perKm = 3.5;
        return base + (distanceKm * perKm);
    }

    // Problem: returns a value but declared as void
    public void buildStory() {

        // Problem: local variable used before it is assigned
        String customerName;

        if (destination.length() > 5) {
            int etaMinutes = 35;
        }

        // Problem: etaMinutes is out of scope here
        System.out.println("ETA: " + etaMinutes + " minutes");

        // Problem: wrong variable name (typo)
        System.out.println("Destination: " + destnation);

        double charge = calculateCharge(distanceKm);

        // Problem: charge declared twice in the same scope
        double charge = charge + 5;

        System.out.println("Order ID: " + orderId);
        System.out.println("Customer: " + customerName);
        System.out.println("Distance: " + distanceKm + " km");
        System.out.println("Delivery Charge: " + charge);

        return "Story: " + customerName + " placed an order to " + destination +
                " and it will arrive in " + etaMinutes + " minutes.";
    }

    public static void main(String[] args) {

        // Problem: object creation without new
        StoryGenerator story = StoryGenerator(102);

        // Problem: calling a non-static method incorrectly from static context
        buildStory();

        System.out.println("Done.");
    }
}
```

---

## After fixing, your program must print a story

Your output does not need to match character-by-character, but it must include all of the following:

- Order ID: `102`
- Customer name: **Abdul Kalam**
- Destination: `MG Road`
- Distance in km (a number)
- Delivery charge (a number)
- A final story sentence
- “Done.”

---

## Comment requirement

In the same file, add comments directly above **any five lines you changed**, explaining what the issue was and what you did to fix it.

Example comment style:
```java
// Fix: This variable was declared but not initialized, so I assigned a value before using it.
```

---