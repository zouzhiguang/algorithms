package com.interview.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Vincent
 * @since:12:17 PM, 26/6/2016
 */
public class ThreeSumTargetNumber {
    public List<List<Integer>> threeSum(int[] nums, int K) {
        List<List<Integer>> results = new ArrayList<>();
        if(nums == null || nums.length < 3){
            return results;
        }

        sort(nums);

        for(int i=0; i+2<nums.length && nums[i] <=K ; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int start = i+1;
            int end = nums.length - 1;
            int lastValue = nums[start];
            while(end >start){
                int sum = nums[i] + nums[start] + nums[end];
                if(sum > K){
                    end--;
                }else {
                    if(sum == K && (lastValue != nums[start] || start == i+1)){
                        // find one that the sum is 0
                        List<Integer> result = new ArrayList<Integer>();
                        result.add(nums[i]);
                        result.add(nums[start]);
                        result.add(nums[end]);
                        results.add(result);
                        lastValue = nums[start];
                    }
                    // need to ensure next start i
                    start ++;
                }
            }
        }

        return results;
    }

    private void sort(int[] nums){
        for(int i = 0; i < nums.length; i++){
            for(int j = nums.length - 1; j>i; j--){
                if(nums[i] > nums[j]){
                    swap(nums, i, j);
                }
            }
        }
    }

    private void swap(int[] nums, int low, int high){
        int tmp = nums[low];
        nums[low] = nums[high];
        nums[high] = tmp;
    }
}
