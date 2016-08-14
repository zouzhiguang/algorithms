package com.interview.leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return all possible palindrome partitioning of s.
 *
 * For example, given s = "aab",
 * Return:
 *
 *  [
 *      ["aa","b"],
 *      ["a","a","b"]
 *  ]
 *
 *  @see <a href="https://leetcode.com/problems/palindrome-partitioning/">Palindrome Partitioning<a/>
 */
public class PalindromePartition131 {
    Map<String, Boolean> cache = new HashMap<>();
    private int length = 0;

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        length = s.length();
        part(s, 0, new ArrayList<>(), result);
        return result;

    }

    public void part(String s, int start, List<String> current, List<List<String>> result) {
        if (start == length) {
            result.add(new ArrayList(current));
            return;
        }

        for (int i = start + 1; i <= length; i++) {
            String scan = s.substring(start, i);
            if (!isPalindrome(scan)) {
                continue;
            }

            current.add(scan);
            part(s, i, current, result);
            current.remove(current.size() - 1);
        }
    }

    public boolean isPalindrome(String s) {
        Boolean result = cache.get(s);
        if (result == null) {
            result = isPalindromeInternal(s);
            cache.put(s, result);
        }

        return result;
    }

    private boolean isPalindromeInternal(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
