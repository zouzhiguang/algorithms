package com.interview.leetcode.dp.impls;

import com.interview.leetcode.dp.WildCardMatching;

/**
 * running time 7 ms.
 */
public class WildCardGreedySolution implements WildCardMatching {
    public boolean isMatch(String s, String p) {
        if (p == null || p.isEmpty()) {
            return s == null || s.isEmpty();
        }
        int i = 0;
        int j = 0;
        int star = -1;
        int mark = -1;
        while (i < s.length()) {
            if (j < p.length() && matchSingle(s, p, i, j)) {
                i++;
                j++;
            } else if (j < p.length() && p.charAt(j) == '*') {
                mark = i;
                star = j++;
            } else if (star != -1) {
                // star encontered....
                i = ++mark;
                j = star + 1;
            } else {
                return false;
            }
        }

        while (j < p.length() && p.charAt(j) == '*') {
            j++;
        }

        return j == p.length();
    }

    public boolean matchSingle(String s, String p, int i, int j) {
        return p.charAt(j) == '?' || s.charAt(i) == p.charAt(j);
    }
}
