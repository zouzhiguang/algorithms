package com.interview.leetcode.arrays.twopointers;

/**
 * Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 * For example, given the array [2,3,1,2,4,3] and s = 7,
 * the subarray [4,3] has the minimal length under the problem constraint.
 * More practice:
 * If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 */
public class MinimalSizeSubarraySum
{
    public int minSubArrayLen_TwoPointers(int s, int[] nums)
    {
        int left = 0, right = 0, sum = 0, length = Integer.MAX_VALUE;
        while (right < nums.length || sum >= s)
        {
            if (sum < s)
            {
                sum += nums[right++];
            }
            else
            {
                length = Math.min(length, right - left);
                sum -= nums[left++];
            }
        }

        return length == Integer.MAX_VALUE ? 0 : length;
    }

    public int minSubArrayLen_BinarySearch(int s, int[] nums)
    {
        int[] sums = new int[nums.length + 1];

        int length = Integer.MAX_VALUE;
        for (int i = 1; i < sums.length; i++)
            sums[i] = sums[i - 1] + nums[i - 1];
        for (int i = 0; i < sums.length; i++)
        {
            int right = search(sums, i + 1, sums.length - 1, sums[i] + s);
            if (right >= sums.length)
                break;
            length = Math.min(length, right - i);
        }
        return length == Integer.MAX_VALUE ? 0 : length;
    }

    private int search(int[] sums, int start, int end, int target)
    {
        while (start <= end)
        {
            int mid = (start + end) / 2;
            if(sums[mid] >= target) {
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return start;
    }
}
