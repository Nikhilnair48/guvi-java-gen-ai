package com.guvi;

/**
 ## How to think about it

 You’re choosing two lines `i` and `j` to form a container.

 * Width = `j - i`
 * Water height = `min(height[i], height[j])` (the shorter wall limits water)
 * Area = `width * minHeight`

 So the task is: maximize
 `(j - i) * min(height[i], height[j])`

 ## Intuition

 Heights: `[2, 1, 3]`

 Possible pairs:

 * (0,1): width 1, minHeight 1 → area 1
 * (0,2): width 2, minHeight 2 → area 4 (best)
 * (1,2): width 1, minHeight 1 → area 1

 Notice: even though `3` is tall, it’s limited by `2` when paired with it.
*/
public class ContainerWithMostWater {
    public static void main(String[] args) {

    }
}
