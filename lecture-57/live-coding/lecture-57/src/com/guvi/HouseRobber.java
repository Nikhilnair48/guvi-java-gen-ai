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
}
