package com.interview.leetcode.impls;

import com.interview.leetcode.CombinationSubset;

import java.util.ArrayList;
import java.util.List;

/**
 * A has NO duplicated values, get all combinations of length K (K <= N).
 * @author: Vincent
 * @since:11:40 PM, 8/7/2016
 */
public class CombinationSubSetNoDup implements CombinationSubset{
    @Override
    public List<List<Integer>> combinationSub(int[] A, int K) {
        List<List<Integer>> results = new ArrayList<>();
        if(A == null || A.length <= 0){
            return results;
        }
        for(int i=0; i<=A.length - K; i++){
            List<Integer> result = new ArrayList<>();
            result.add(A[i]);
            combine(A, i, K - 1, result, results);
        }
        return results;
    }

    public void combine(int[] A, int low, int K, List<Integer> result, List<List<Integer>> results){
        if(K == 0){
            results.add(new ArrayList<>(result));
            return;
        }
        if(low >= A.length) return;
        for(int i = low + 1; i < A.length; i++){
            result.add(A[i]);
            combine(A, i , K-1, result, results);
            result.remove(result.size() - 1);
        }
    }
}
