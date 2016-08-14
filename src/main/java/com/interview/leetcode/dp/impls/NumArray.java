package com.interview.leetcode.dp.impls;

public class NumArray {
    private final int[] state;
    private final int length;

    public NumArray(int[] nums) {
        length = nums.length;
        int len = getCord(length - 1, length - 1);
        state = new int[len+1];
        for(int i = 0; i<nums.length;i++){
            int start = getCord(i, i);
            state[start] = nums[i];
            for(int j = i+1; j < nums.length;j++){
                state[start + j - i] = state[start + j-1] + nums[j];
            }
        }
    }

    public int sumRange(int i, int j) {
        return state[getCord(i, j)];
    }

    public int getCord(int from, int to) {
        int cord = 0;
        for(int i = from; i >0; i--){
            cord += length - i;
        }

        return cord + to - from;
    }


}
