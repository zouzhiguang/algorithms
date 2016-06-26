package com.interview.leetcode.impls;

import com.interview.leetcode.IntegerStream;

import java.util.ArrayList;

public class IntegerStreamMinHeap implements IntegerStream {
    private ArrayList<Integer> nums;
    private int counter = 0;
    private int K;
    private int ROOT = 1;

    public IntegerStreamMinHeap(int K) {
        nums = new ArrayList<>(K + 2);
        nums.add(null);
        this.K = K;
    }

    @Override
    public void write(int value) {
        // your solution here
        // add new to the end of queue
        nums.add(value);
        counter ++;
        // swim to correct position
        swim(counter);

        // if size > k it means the root is not k'th in the queue, de-stack the root and balance the root
        if (counter > K) {
            // delete the root as it's no longer the kth largest.
            swap(ROOT, counter);
            nums.remove(counter--);
            sink(ROOT);
        }
    }

    private void swim(int child) {
        // parent should be smaller than child
        while (child > ROOT && nums.get(child / 2) > nums.get(child)) {
            swap(child / 2, child);
            child = child / 2;
        }
    }

    private void sink(int base) {
        while(base * 2 <= counter){
            int child = base * 2;
            // root should be smaller than both child
            // get smaller child to compare with root
            if(child < counter && nums.get(child) > nums.get(child + 1)){
                child ++;
            }

            // if root is smaller than the both child, it's in right position
            if(nums.get(base) < nums.get(child)){
                break;
            }

            swap(base, child);
            base = child;
        }

    }

    @Override
    public int get() {
        // 0 is reserved for convenience.
        return nums.get(1);
    }

    private void swap(int first, int second) {
        int tmp = nums.get(first);
        nums.set(first, nums.get(second));
        nums.set(second, tmp);
    }
}
