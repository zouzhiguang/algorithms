package com.interview.algorithms.data.structures.impls;

import com.interview.algorithms.data.structures.CombinationSum;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Vincent
 * @since:12:42 PM, 5/7/2016
 */
public class CombinationSumNoDuplicate040 implements CombinationSum {

    @Override
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<>();
        combine(nums, 0, 1, 0, target, new ArrayList<>(), results);
        return results;
    }

    public void combine(int[] nums, int low, int high, int sum, int target, List<Integer> result, List<List<Integer>> results) {
        if (low >= nums.length) {
            // finish search already.
            return;
        }

        if (high >= nums.length) {
            // low is not a number in the solution. so we need to drop all low solution.
            combine(nums, low + 1, low + 2, 0, target, new ArrayList<>(), results);
            return;
        }

        if (result.isEmpty() && low == high && nums[low] > target) {
            // low can not be one in the solution, just drop low
            // eg, [3,4,5,6,...., 100000] find 2
            combine(nums, low + 1, low + 2, 0, target, result, results);
            return;
        }

        if (sum == target) {
            // found solution, add to results
            List<Integer> solution = new ArrayList<>();
            solution.addAll(result);
            results.add(solution);
        }

        if (sum < target) {
            // sum is smaller, just add current high and try again.
            int cursor = high;
            while (cursor + 1 < nums.length) {
                // search high.....end
                result.add(nums[cursor]);
                combine(nums, low, cursor + 1, sum + nums[cursor], target, result, results);
                result.remove(result.size() - 1);
                cursor++;
            }
        }
    }
}
