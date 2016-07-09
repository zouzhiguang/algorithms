package com.interview.algorithms.data.structures.impls;

import com.interview.algorithms.data.structures.CombinationSum;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Vincent
 * @since:9:05 AM, 5/7/2016
 */
public class CombinationSumIDuplicate039 implements CombinationSum {

    @Override
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<>();
        combin(nums, 0, 0, 0, target, new ArrayList<Integer>(), results);
        return results;
    }

    public void combin(int[] nums, int low, int high, int sum, int target, List<Integer> result, List<List<Integer>> results){
        if (low >= nums.length) {
            // finish search already.
            return;
        }

        if (high >= nums.length) {
            // low is not a number in the solution. so we need to drop all low solution.
            combin(nums, low + 1, low + 1, 0, target, new ArrayList<Integer>(), results);
            return;
        }

        if(result.isEmpty() && low == high && nums[low] > target){
            // low can not be one in the solution, just drop low
            // eg, [3,4,5,6,...., 100000] find 2
            combin(nums, low + 1, low + 1, 0, target, result, results);
            return;
        }

        if(sum == target){
            // found solution, add to results
            List<Integer> solution = new ArrayList<>();
            solution.addAll(result);
            results.add(solution);
        }

        if(sum < target){
            // sum is smaller, just add current high and try again.
            int cursor = high;
            while(cursor < nums.length){
                // search high + 1.....end
                result.add(nums[cursor]);
                combin(nums, low, cursor, sum + nums[cursor], target, result, results);
                result.remove(result.size() - 1);
                cursor++;
            }
        }
    }
}
