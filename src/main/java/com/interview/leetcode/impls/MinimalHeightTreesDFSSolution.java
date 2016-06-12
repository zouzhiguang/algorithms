package com.interview.leetcode.impls;

import com.interview.leetcode.MinimalHeightTrees310;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: Vincent
 * @since:11:00 AM, 11/6/2016
 */
public class MinimalHeightTreesDFSSolution implements MinimalHeightTrees310 {

    @Override
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList();
        List<Integer>[] connections = new ArrayList[n];
        for(int i=0; i<n; i++){
            connections[i] = new ArrayList<Integer>();
        }
        for(int[] edge : edges){
            connections[edge[0]].add(edge[1]);
            connections[edge[1]].add(edge[0]);
        }
        Stack<Integer> stack = new Stack<Integer>();
        Integer min = null;

        for(int i=0; i<n; i++){
            if(connections[i].size() == 1){
                // leaf node can not be root.
                continue;
            }
            int current = 1;
            boolean[] marked = new boolean[n];
            stack.clear();
            stack.push(i);
            marked[i] = true;
            next:
            while(!stack.empty()){
                int node = stack.pop();
                for(int adj : connections[node]){
                    if(!marked[adj]){
                        marked[adj] = true;
                        stack.push(node);
                        stack.push(adj);
                        int size = stack.size();
                        if(size > current){
                            current = size;
                        }

                        if(min != null && min < current){
                            break next;
                        }

                        break;
                    }
                }
            }

            if(min == null || min >= current){
                if(min == null || min > current){
                    min = current;
                    result.clear();
                }
                result.add(i);
            }
        }

        return result;
    }
}
