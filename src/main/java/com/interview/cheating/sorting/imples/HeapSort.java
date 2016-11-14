package com.interview.cheating.sorting.imples;

import com.interview.cheating.sorting.Sorting;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * For PriorityQueue Implementation, please practise when do data structure practices.
 */
public class HeapSort extends Sorting {
    @Override
    public void sort(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int num : nums) {
            queue.offer(num);
        }
        int counter = 0;
        while (!queue.isEmpty())
            nums[counter++] = queue.poll();
    }

    public static void main(String... args) {
        HeapSort sort = new HeapSort();
        int[] test = new int[] {9, 2, 5, 7, 1, 3, 6, 8, 4};
        sort.sort(test);

        System.out.println(Arrays.toString(test));
    }
}
