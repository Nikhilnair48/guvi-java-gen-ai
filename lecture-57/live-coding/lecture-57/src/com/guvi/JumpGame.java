package com.guvi;

/**
 ## How to think about it

 You’re at index `0`. Each `nums[i]` tells you the maximum jump length from `i`.
 Question: Can you reach the last index? (Yes/No)

 This is *not* “minimum jumps” (that’s Jump Game II). Here it’s just reachability.

 ## Intuition

 ### Example 1: `[2,3,1,1,4]` -> true

 From 0 you can reach up to index 2. From 1 you can reach up to 4. So last index is reachable.

 ### Example 2: `[3,2,1,0,4]` -> false

 You can get to index 3, but `nums[3]=0` blocks you. You can’t reach 4.

 A good mental model: you’re maintaining a “farthest reachable boundary” as you scan left -> right.
*/
public class JumpGame {
    /**
     ## Approach 1: Brute force (DFS / recursion)

     From each index, try all jumps `1..nums[i]` and see if any path reaches the end.

     * Time: exponential in worst case (lots of branching)
     * Space: recursion stack
    */
    public boolean canJump(int[] nums) {
        return dfs(nums, 0, new boolean[nums.length]);
    }

    private boolean dfs(int[] nums, int i, boolean[] visiting) {
        if (i >= nums.length - 1) return true;
        if (visiting[i]) return false;

        visiting[i] = true;
        int furthest = Math.min(nums.length - 1, i + nums[i]);

        for (int next = i + 1; next <= furthest; next++) {
            if (dfs(nums, next, visiting)) return true;
        }

        visiting[i] = false;
        return false;
    }


    /**
     ## Approach 2: Optimal Greedy (single pass)

     Maintain:

     * `farthest` = the maximum index we can reach so far

     Scan `i` from `0` to `n-1`:

     * If `i > farthest`, it means we can’t even stand on `i` -> return false
     * Otherwise update `farthest = max(farthest, i + nums[i])`
     * If `farthest >= n-1`, return true early
    */
    public boolean canJumpOptimized(int[] nums) {
        int reach = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > reach) return false;
            reach = Math.max(reach, i + nums[i]);
        }

        return true;
    }

}
