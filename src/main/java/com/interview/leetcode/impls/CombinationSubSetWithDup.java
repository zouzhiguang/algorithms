package com.interview.leetcode.impls;

import com.interview.leetcode.CombinationSubset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSubSetWithDup implements CombinationSubset {
    private static final int M = 1;

    @Override
    public List<List<Integer>> combinationSub(int[] A, int K) {
        List<List<Integer>> results = new ArrayList<>();
        if(A == null || A.length <= 0){
            return results;
        }
        Arrays.sort(A);
        for(int i=0; i<=A.length - K; i++){
            if(i > M && A[i] == A[i-1 - M]){
                continue;
            }
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
            if(i > low + 1 && A[i] ==A[i-1]){
                continue;
            }
            result.add(A[i]);
            combine(A, i , K-1, result, results);
            result.remove(result.size() - 1);
        }
    }
}
