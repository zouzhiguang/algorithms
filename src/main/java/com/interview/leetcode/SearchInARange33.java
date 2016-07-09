package com.interview.leetcode;

/**
 * @author: Vincent
 * @since:3:34 PM, 1/7/2016
 */
public class SearchInARange33 {

    public int[] searchRange(int[] nums, int target) {
        return search(nums, target, 0, nums.length);
    }

    public int[] search(int[] nums, int target, int low, int high) {
        if (low > high) {
            return new int[] {
                -1, -1
            } ;
        }

        int mid = low + (high - low) / 2;
        if (nums[mid] > target) {
            return search(nums, target, low, mid - 1);
        } else if (nums[mid] < target) {
            return search(nums, target, mid + 1, high);
        } else {
            //find the target, maybe it's in the sequence middle.
            int lowS = findSingleSide(nums, target, low, mid, true);
            int highS = findSingleSide(nums, target, mid, high, false);
            return new int[] {
                lowS, highS
            } ;
        }
    }

    public int findSingleSide(int[] nums, int target, int low, int high, boolean dropLeft) {
        if (low >= high) {
            // if no more, return the side that not drop
            return dropLeft ? high : low;
        }

        int mid = low + (high - low) / 2;
        if (nums[mid] < target) {
            return findSingleSide(nums, target, mid + 1, high, true);
        } else if (nums[mid] > target) {
            return findSingleSide(nums, target, low, mid - 1, false);
        } else {
            // mid is target, but still, it may be in the sequence.
            if (dropLeft) {
                // index should be in low.....index.....middle
                return findSingleSide(nums, target, low, mid, true);
            } else {
                // index should be in middle....index....high
                return findSingleSide(nums, target, mid, high, false);
            }
        }
    }
}
