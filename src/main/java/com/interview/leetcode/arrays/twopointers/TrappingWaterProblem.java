package com.interview.leetcode.arrays.twopointers;

/**
 * 42. Trapping Rain Water
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 * For example,
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * <img src="src/main/resources/imgs/rainwatertrap.png" /><br />
 *
 * @see <a href="https://leetcode.com/problems/trapping-rain-water/">42. Trapping Rain Water</a>
 */
public interface TrappingWaterProblem
{
    int trap(int[] height);
}
