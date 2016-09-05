package com.interview.leetcode.two_pointers.impls;

import com.interview.leetcode.two_pointers.LongestSubStringWithoutRepeatingChars;

/**
 * @author: Vincent
 * @since:5:36 PM, 4/9/2016
 */
public class SubStringNoRepeatingCharsTwoPointers implements LongestSubStringWithoutRepeatingChars {

    @Override
    public int lengthOfLongestSubstring(String s) {
        int[] table = new int[128];
        int start = -1, end = -1, d = 0;
        // start scan to find a valid answer first
        while (++end < s.length()) {
            // previous have this already, here it should end.
            if (table[s.charAt(end)]++ > 0) {
                d = Math.max(d, end - start - 1);
                while (s.charAt(++start) != s.charAt(end))
                    table[s.charAt(start)]--;
                table[s.charAt(start)]--;
            }
        }
        return Math.max(d, end - start - 1);
    }

    public static void main(String... args) {
        SubStringNoRepeatingCharsTwoPointers solution = new SubStringNoRepeatingCharsTwoPointers();
        int length = solution.lengthOfLongestSubstring("ggububgvfk");
        assert length == 6;
    }
}
