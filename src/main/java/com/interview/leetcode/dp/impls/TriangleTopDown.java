package com.interview.leetcode.dp.impls;

import com.interview.leetcode.dp.Triangle;

import java.util.List;

/**
 * @author: Vincent
 * @since:2:46 PM, 24/7/2016
 */
public class TriangleTopDown implements Triangle {
    private int n = 0;
    private int[][] table = null;

    @Override
    public int minimumTotal(List<List<Integer>> triangle) {
        n = triangle.size();
        table = new int[n][n];
        for(int i = 0; i<n; i++){
            for(int j=0;j<n;j++){
                table[i][j] = Integer.MAX_VALUE;
            }
        }

        search(0, 0, triangle);
        return table[0][0];
    }

    private int search(int i, int j, List<List<Integer>> triangle){
        if(i == n - 1){
            table[i][j] = triangle.get(n-1).get(j);
            return table[i][j];
        }

        if(table[i][j] != Integer.MAX_VALUE){
            return table[i][j];
        }

        table[i][j] = Math.min(search(i + 1, j, triangle) , search(i + 1, j + 1, triangle)) + triangle.get(i).get(j);
        return table[i][j];
    }
}
