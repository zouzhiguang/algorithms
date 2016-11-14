package com.interview.cheating.sorting;

import java.util.Arrays;

/**
 * @author: Vincent
 * @since:4:44 PM, 12/11/2016
 */
public abstract class Sorting {
    public abstract void sort(int[] nums);


    protected void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
