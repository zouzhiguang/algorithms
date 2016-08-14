package com.interview.leetcode.dp;

/**
 * Whether String s match rule p with:
 * - '*' match any sub-sequence
 * - '?' match any single character
 *
 * @see <a href="https://leetcode.com/problems/wildcard-matching/">WildCard Matching</a>
 */
public interface WildCardMatching {
    boolean isMatch(String s, String p);
}
