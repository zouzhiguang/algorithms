package com.interview.leetcode;

//https://leetcode.com/problems/longest-valid-parentheses/
//
public class NextPermutation{
    public void nextPermutation(int[] nums){
        if(nums.length <= 1){
            return;
        }

        // find the violation index
        int index = nums.length -2;
        while(index >= 0){
            if(nums[index+1] > nums[index]){
                break;
            }
            index--;
        }

        if(index < 0){
            // it's in descending order, we would make it ascending order.
            reverse(nums, 0, nums.length - 1);
            return;
        }
        // swap the index with next letter which is next the current
        int nextIndex = index;
        int value = Integer.MAX_VALUE;
        for(int i = index; i< nums.length; i++){
            if(nums[i] > nums[index] && nums[i] <= value){
                value = nums[i];
                nextIndex = i;
            }
        }

        swap(nums, index++, nextIndex);

        // reverse from index to end
        int end = nums.length - 1;
        reverse(nums, index, nums.length - 1);
    }

    void swap(int[] nums, int first, int second){
        int tmp = nums[first];
        nums[first] = nums[second];
        nums[second] = tmp;
    }

    void reverse(int[] nums, int start, int end){
        while(start < end){
            swap(nums, start++, end--);
        }
    }
}
