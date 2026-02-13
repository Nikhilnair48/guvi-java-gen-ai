package com.guvi;

/**
 ## How to think about it

 You want the **maximum-length contiguous window** (substring) where **all characters are unique**.

 Key idea: As you scan left → right, you maintain a window `[L..R]` that is always valid (no repeats).
 When a repeat happens at `R`, you **shrink from the left just enough** to restore validity.
*/
public class LongestSubstringWithoutRepeatingCharacters {
}
