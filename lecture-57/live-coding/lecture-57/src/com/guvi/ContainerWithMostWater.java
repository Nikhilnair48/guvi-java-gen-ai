package com.guvi;

/**
 ## How to think about it

 You’re choosing two lines `i` and `j` to form a container.

 * Width = `j - i`
 * Water height = `min(height[i], height[j])` (the shorter wall limits water)
 * Area = `width * minHeight`

 So the task is: maximize
 `(j - i) * min(height[i], height[j])`

*/
public class ContainerWithMostWater {
    public static void main(String[] args) {

    }
}
