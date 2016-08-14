package com.interview.leetcode.dp.impls;

import com.interview.leetcode.dp.WildCardMatching;

/**
 * running time 164 ms.
 */
public class WildCardMatchDPSolution implements WildCardMatching {
    public boolean isMatch(String s, String p) {
        if (p == null || p.isEmpty()) {
            return s == null || s.isEmpty();
        }

        // match[i][j] means if pre-i'th char in s match pre-j'th char in p
        boolean[][] match = new boolean[s.length() + 1][p.length() + 1];

        // init:
        match[0][0] = true;
        for (int j = 1; j <= p.length(); j++) {
            // handle prefix with *
            if (p.charAt(j - 1) == '*')
                match[0][j] = match[0][j - 1];
        }

        // state transfer formula:
        for (int i = 1; i < match.length; i++) {
            for (int j = 1; j < match[0].length; j++) {
                if (p.charAt(j - 1) == '*') {
                    //match[i-1][j]: * match any char, match[i-1][j-1]: * match empty string.
                    match[i][j] = match[i - 1][j] || match[i][j - 1] || match[i - 1][j - 1];
                } else {
                    match[i][j] = match[i - 1][j - 1] && matchSingle(s, p, i, j);
                }
            }
        }

        // result
        return match[s.length()][p.length()];
    }

    public boolean matchSingle(String s, String p, int i, int j) {
        return p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1);
    }
}
