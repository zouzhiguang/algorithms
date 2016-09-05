package com.interview.leetcode;

/**
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
 * You can only see the k numbers in the window.
 * Each time the sliding window moves right by one position.
 * <p>
 * For example,
 * Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
 * Therefore, return the max sliding window as [3,3,5,5,6,7].
 *
 * @see <a href="https://leetcode.com/problems/sliding-window-maximum/">239. Sliding Window Maximum</a>
 */
public interface SlidingWindowMaximumNumber {
    int[] maxSlidingWindow(int[] nums, int k);
}
