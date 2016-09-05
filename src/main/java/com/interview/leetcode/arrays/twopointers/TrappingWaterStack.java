package com.interview.leetcode.arrays.twopointers;

import java.util.Stack;

// time: O(n^2), space: O(n), running time: 20ms
public class TrappingWaterStack implements TrappingWaterProblem
{
    @Override
    public int trap(int[] height)
    {
        Stack<Integer> stack = new Stack<>();
        int currentMax = 0;
        int trapped = 0;
        for (int i = 0; i < height.length; i++)
        {
            if(stack.isEmpty()){
                if(stack.isEmpty() && height[i] == 0){
                    continue;
                }

                currentMax = height[i];
            }
            // goes down
            else if (stack.peek() < height[i])
            {
                int count = 0;
                while(!stack.isEmpty() && stack.peek() < height[i]){
                    count ++;
                    trapped += (height[i] - stack.pop());
                }
                if(!stack.isEmpty()){
                    while (count > 0){
                        stack.push(height[i]);
                        count--;
                    }
                }else {
                    trapped -= (height[i] - currentMax) * count;
                    currentMax = height[i];
                }
            }
            stack.push(height[i]);
        }
        return trapped;
    }
}
