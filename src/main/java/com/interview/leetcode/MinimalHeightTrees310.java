package com.interview.leetcode;



import java.util.List;

/**
 * For a undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). Given such a graph, write a function to find all the MHTs and return a list of their root labels.
 * <p>
 * Format
 * The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of undirected edges (each edge is a pair of labels).
 * <p>
 * You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 *
 * @author: Vincent
 * @since: 10:59 AM, 11/6/2016
 * @see <a href=https://leetcode.com/problems/minimum-height-trees/>minimum-height-trees</a>
 */
public interface MinimalHeightTrees310 {
    List<Integer> findMinHeightTrees(int n, int[][] edges);
}
