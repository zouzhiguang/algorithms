package com.interview.cheating.sorting.imples;

import com.interview.cheating.sorting.Sorting;

import java.util.Arrays;

/**
 * @author: Vincent
 * @since:6:06 PM, 12/11/2016
 */
public class ThreeWayQuickSort extends Sorting {
    @Override
    public void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums, int low, int high) {
        if(low >= high) return;

        // make lessThan ~ moreThan inclusive are all equal to nums[end]
        int lessThan = low, cursor = high - 1, moreThan = high;
        int value = nums[high];
        while(cursor >= lessThan){
            if(nums[cursor] > value){
                swap(nums, cursor, moreThan--);
            }else if(nums[cursor] < value){
                swap(nums, cursor, lessThan++);
            }else {
                cursor--;
            }
        }

        sort(nums, low, lessThan - 1);
        sort(nums, moreThan + 1, high);
    }

    public static void main(String... args) {
        ThreeWayQuickSort sort = new ThreeWayQuickSort();
        int[] test = new int[] {9, 2, 5, 7, 1, 3, 6, 8, 4};
        sort.sort(test);

        System.out.println(Arrays.toString(test));
    }
}
