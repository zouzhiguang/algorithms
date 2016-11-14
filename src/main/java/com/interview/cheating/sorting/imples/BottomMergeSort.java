package com.interview.cheating.sorting.imples;

import java.util.Arrays;

/**
 * @author: Vincent
 * @since:5:39 PM, 12/11/2016
 */
public class BottomMergeSort extends MergeSort {
    @Override
    public void sort(int[] nums) {
        int[] arb = new int[nums.length];
        for (int size = 1; size < nums.length; size += size){
            for(int low = 0; low < nums.length - size; low += size * 2){
                merge(nums, low, low + size - 1, Math.min(low + size * 2 - 1, nums.length - 1), arb);
            }
        }
    }

    public static void main(String... args) {
        BottomMergeSort sort = new BottomMergeSort();
        int[] test = new int[] {9, 2, 5, 7, 1, 3, 6, 8, 4};
        sort.sort(test);

        System.out.println(Arrays.toString(test));
    }
}
