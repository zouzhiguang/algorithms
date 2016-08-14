package com.interview.leetcode.dp;

import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * <p>
 * For example, given the following triangle:
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * <p>
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 *
 * @see <a href="https://leetcode.com/problems/triangle/">Leetcode 120. Triangle<a/>
 *
 * @author: Vincent
 */
public interface Triangle {
    int minimumTotal(List<List<Integer>> triangle);
}
