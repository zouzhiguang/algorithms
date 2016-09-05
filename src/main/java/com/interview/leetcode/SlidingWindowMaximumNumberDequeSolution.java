package com.interview.leetcode;

import java.util.LinkedList;

/**
 * @see <a href="https://discuss.leetcode.com/topic/19055/java-o-n-solution-using-deque-with-explanation">Java O(n) solution using deque with explanation</a>
 */
// Time O(n), space O(n)
public class SlidingWindowMaximumNumberDequeSolution implements SlidingWindowMaximumNumber {
    @Override
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k <= 0) return new int[0];
        LinkedList<Integer> window = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            if (!window.isEmpty() && window.peek() < i - k + 1) window.poll();
            while (!window.isEmpty() && nums[window.peekLast()] < nums[i]) window.pollLast();
            window.offer(i);
            if (i >= k - 1) result[i - k + 1] = nums[window.peek()];
        }

        return result;
    }
}
