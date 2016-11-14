package com.interview.cheating.sorting.imples;

import com.interview.cheating.sorting.Sorting;

import java.util.Arrays;

/**
 * @author: Vincent
 * @since:5:15 PM, 12/11/2016
 */
public class MergeSort extends Sorting {
    @Override
    public void sort(int[] nums) {
        sort(nums, 0, nums.length - 1, new int[nums.length]);
    }

    private void sort(int[] nums, int start, int end, int[] arb) {
        if (start >= end)
            return;
        int mid = start + (end - start) / 2;
        sort(nums, start, mid, arb);
        sort(nums, mid + 1, end, arb);
        merge(nums, start, mid, end, arb);
    }

    protected void merge(int[] nums, int start, int mid, int end, int[] arb) {
        int j = start, k = mid + 1;
        for (int i = start; i <= end; i++) {
            if (j > mid) {
                arb[i] = nums[k++];
            } else if (k > end) {
                arb[i] = nums[j++];
            } else if (nums[j] > nums[k]) {
                arb[i] = nums[k++];
            } else {
                arb[i] = nums[j++];
            }
        }

        System.arraycopy(arb, start, nums, start, end - start + 1);
    }


    public static void main(String... args) {
        MergeSort sort = new MergeSort();
        int[] test = new int[] {9, 2, 5, 7, 1, 3, 6, 8, 4};
        sort.sort(test);

        System.out.println(Arrays.toString(test));
    }

}
