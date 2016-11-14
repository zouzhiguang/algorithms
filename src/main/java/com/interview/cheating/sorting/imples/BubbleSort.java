package com.interview.cheating.sorting.imples;

import com.interview.cheating.sorting.Sorting;

import java.util.Arrays;

/**
 * @author: Vincent
 * @since:4:45 PM, 12/11/2016
 */
public class BubbleSort extends Sorting {
    @Override
    public void sort(int[] nums) {
        if (nums == null || nums.length <= 1)
            return;

        for (int i = nums.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    public static void main(String... args) {
        BubbleSort sort = new BubbleSort();
        int[] test = new int[] {9, 2, 5, 7, 1, 3, 6, 8, 4};
        sort.sort(test);

        System.out.println(Arrays.toString(test));
    }

}
