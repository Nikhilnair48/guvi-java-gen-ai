package com.guvi;

/**
 ## How to think about it
 You have houses in a line. Each house has money `nums[i]`.
 Constraint: if you rob house `i`, you cannot rob `i-1` or `i+1`.

 Goal: maximize total money.

 This screams DP because every choice at `i` depends on what you did at `i-1`.

 ## Intuition

 ### Example 1: `[1,2,3,1]`

 Best is `1 + 3 = 4` (rob houses 0 and 2)

 ### Example 2: `[2,7,9,3,1]`

 * If you take 9 (index 2), you can’t take 7 (index 1) or 3 (index 3)
 Best is `2 + 9 + 1 = 12`

 Key mental model: at each house, you choose:

 * skip it (carry forward best so far)
 * take it (add its money to best up to house `i-2`)
*/
public class HouseRobber {
    /**
     ## Approach 1: Brute force (recursion)

     At index `i`, you have two options:

     * rob `i` → move to `i+2`
     * skip `i` → move to `i+1`

     This explores many overlapping subproblems → exponential time.

     * Time: O(2^n)
     * Space: O(n) recursion depth
    */

    /**
     ## Approach 2: DP (optimal) with recurrence

     Let `dp[i]` = max money you can rob from houses `0..i`.

     Then:

     * If you skip house `i`: you keep `dp[i-1]`
     * If you rob house `i`: you get `nums[i] + dp[i-2]`

     So:
     `dp[i] = max(dp[i-1], nums[i] + dp[i-2])`

     Base:

     * `dp[0] = nums[0]`
     * `dp[1] = max(nums[0], nums[1])`

     Answer: `dp[n-1]`

     * Time: O(n)
     * Space: O(n)
    */
}
