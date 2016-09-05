package com.interview.leetcode.arrays.twopointers;

// time O(n), space O(1), runtime: 2ms.
public class TrappingWaterTwoPointer implements TrappingWaterProblem
{
    @Override
    public int trap(int[] height) {
        if(height == null || height.length <= 2) return 0;

        int sum = 0, maxhigh = 0;
        int begin = 0, end = height.length-1;
        while(begin <= end){
            if(height[begin] <= maxhigh){
                sum += maxhigh - height[begin++];
            }
            else if(height[end] <= maxhigh){
                sum += maxhigh - height[end--];
            }
            else{
                maxhigh = Math.min(height[begin], height[end]);
            }
        }
        return sum;
    }
}
