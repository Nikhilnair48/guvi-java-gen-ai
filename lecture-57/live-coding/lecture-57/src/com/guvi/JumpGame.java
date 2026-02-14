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
}
