package com.interview.leetcode.dp;

import com.google.common.base.Joiner;
import com.interview.algorithms.princeton.CommonTest;
import com.interview.leetcode.dp.impls.WildCardGreedySolution;
import com.interview.leetcode.dp.impls.WildCardMatchDPSolution;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author: Vincent
 * @since:1:30 PM, 14/8/2016
 */
public class WildCardMatchingTest extends CommonTest {

    @Test(dataProvider = "prepareInstance")
    public void testWildCardMatching(String description, WildCardMatching target, String s, String p, boolean expected) {
        logger.debug(description);
        assertEquals(target.isMatch(s, p), expected, Joiner.on(" ").join("Testing s=", s, "and p =", p));
    }

    @Override
    @DataProvider
    protected Object[][] prepareInstance() {
        return new Object[][] {
            {"WildCardMatchingTest, DP Solution", new WildCardMatchDPSolution(), "aab", "c*a*b", false},
            {"WildCardMatchingTest, DP Solution", new WildCardMatchDPSolution(), "aa", "a", false},
            {"WildCardMatchingTest, DP Solution", new WildCardMatchDPSolution(), "c", "*?*", true},
            {"WildCardMatchingTest, DP Solution", new WildCardMatchDPSolution(), "dajskdlialekwnkjqdhia", "da*ia*j?*a", true},
            {"WildCardMatchingTest, greedy Solution", new WildCardGreedySolution(), "aab", "c*a*b", false},
            {"WildCardMatchingTest, greedy Solution", new WildCardGreedySolution(), "aa", "a", false},
            {"WildCardMatchingTest, greedy Solution", new WildCardGreedySolution(), "c", "*?*", true},
            {"WildCardMatchingTest, greedy Solution", new WildCardGreedySolution(), "dajskdlialekwnkjqdhia", "da*ia*j?*a", true},
        };
    }
}
