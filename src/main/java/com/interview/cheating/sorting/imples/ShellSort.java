package com.interview.cheating.sorting.imples;

import com.interview.cheating.sorting.Sorting;

import java.util.Arrays;

/**
 * @author: Vincent
 * @since:6:21 PM, 12/11/2016
 */
public class ShellSort extends Sorting {
    @Override
    public void sort(int[] nums) {
        int length = nums.length, size = 1;
        while (size < length / 3)
            size = size * 3 + 1;

        for (; size >= 1; size /= 3) {
            for (int i = size; i < length; i++) {
                for (int j = i; j >= size && nums[j] < nums[j - size]; j -= size) {
                    swap(nums, j, j - size);
                }
            }
        }
    }

    public static void main(String... args) {
        ShellSort sort = new ShellSort();
        int[] test = new int[] {9, 2, 5, 7, 1, 3, 6, 8, 4};
        sort.sort(test);

        System.out.println(Arrays.toString(test));
    }
}
