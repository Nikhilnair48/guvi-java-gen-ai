package com.guvi;

import java.util.HashSet;
import java.util.Set;

/**
 ## How to think about it

 You want the **maximum-length contiguous window** (substring) where **all characters are unique**.

 Key idea: As you scan left → right, you maintain a window `[L..R]` that is always valid (no repeats).
 When a repeat happens at `R`, you **shrink from the left just enough** to restore validity.

 ## Intuition

 ### Example 1: `"abcabcbb"`
 * Longest unique substring is `"abc"` → length 3

 ### Example 2: `"pwwkew"`
 * Longest unique substring is `"wke"` → length 3 (note: `"pwke"` is NOT contiguous)

 ### Example 3: `"bbbbb"`
 * Longest is `"b"` → length 1
*/
public class LongestSubstringWithoutRepeatingCharacters {
    /**
     ## Approach 1: Brute force

     Try every starting index `i`, expand `j` forward until you hit a repeat (track seen chars with a Set), update max.

     * Time: O(n²) (each start expands potentially up to n)
     * Space: O(min(n, charset))

     This is teachable and straightforward, but still slower than necessary.
    */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int best = 0;

        for (int i = 0; i < n; i++) {
            boolean[] seen = new boolean[128];
            for (int j = i; j < n; j++) {
                char c = s.charAt(j);
                if (seen[c]) break;
                seen[c] = true;
                best = Math.max(best, j - i + 1);
            }
        }

        return best;
    }


    /**
     ## Approach 2: Optimal (Sliding Window + last seen index)

     Maintain:

     * `L` = left pointer of current window
     * `lastSeen[ch]` = most recent index where `ch` appeared

     When you see `ch` at index `R`:

     * If `ch` was seen inside the current window (`lastSeen[ch] >= L`), then move:

     * `L = lastSeen[ch] + 1`
     * Update `lastSeen[ch] = R`
     * Update answer with `R - L + 1`
    */

    public int lengthOfLongestSubstringOptimized(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0;
        int best = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(c);
            best = Math.max(best, right - left + 1);
        }

        return best;
    }

}
