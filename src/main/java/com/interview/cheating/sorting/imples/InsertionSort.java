package com.interview.cheating.sorting.imples;

import com.interview.cheating.sorting.Sorting;

import java.util.Arrays;

/**
 * 把j从j=i到0插入0～i中，遍历i从0到end。
 */
public class InsertionSort extends Sorting {
    @Override
    public void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1])
                    swap(nums, j - 1, j);
            }
        }
    }

    public static void main(String... args) {
        InsertionSort sort = new InsertionSort();
        int[] test = new int[] {9, 2, 5, 7, 1, 3, 6, 8, 4};
        sort.sort(test);

        System.out.println(Arrays.toString(test));
    }
}
