package com.interview.cheating.sorting.imples;

import com.interview.cheating.sorting.Sorting;

import java.util.Arrays;

/**
 * @author: Vincent
 * @since:5:55 PM, 12/11/2016
 */
public class QuickSort extends Sorting {
    @Override
    public void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums, int start, int end) {
        if(start >= end) return;
        int pivot = partition(nums, start, end);
        sort(nums, start, pivot - 1);
        sort(nums, pivot + 1, end);
    }

    private int partition(int[] nums, int start, int end) {
        if(start >= end) return start;
        int begin = start - 1;
        int value = nums[end];
        for(int i = start; i <= end; i++){
            if (nums[i] <= value){
                swap(nums, i, ++begin);
            }
        }
        return begin;
    }


    public static void main(String... args) {
        QuickSort sort = new QuickSort();
        int[] test = new int[] {9, 2, 5, 7, 1, 3, 6, 8, 4};
        sort.sort(test);

        System.out.println(Arrays.toString(test));
    }
}
