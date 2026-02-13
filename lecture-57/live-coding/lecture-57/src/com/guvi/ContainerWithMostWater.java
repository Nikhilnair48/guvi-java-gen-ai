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

    /**
         ## Approach 1: Brute force

         Try every pair `(i, j)` with `i < j`, compute area, keep max.

         Time: O(n²)
         Space: O(1)
         Works, but will time out for large `n` (up to 1e5).
    */
    public int maxArea(int[] height) {
        int n = height.length;
        int best = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int h = Math.min(height[i], height[j]);
                int w = j - i;
                best = Math.max(best, h * w);
            }
        }

        return best;
    }


    /**
     ## Approach 2: Optimal (Two Pointers) — the key greedy idea

     Start with the widest container: `L = 0`, `R = n - 1`.

     At each step:

     1. Compute area using `(L, R)`
     2. Move the pointer at the shorter height

     If `height[L] < height[R]`, do `L++`
     Else do `R--`
     */

    public static void main(String[] args) {

    }
}
