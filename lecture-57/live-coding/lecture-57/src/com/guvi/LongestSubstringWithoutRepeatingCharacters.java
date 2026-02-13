package com.guvi;

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
}
