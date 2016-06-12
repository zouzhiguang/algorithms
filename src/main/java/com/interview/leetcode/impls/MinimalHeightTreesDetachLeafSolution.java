package com.interview.leetcode.impls;

import com.interview.leetcode.MinimalHeightTrees310;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: Vincent
 * @since:1:14 PM, 12/6/2016
 */
public class MinimalHeightTreesDetachLeafSolution implements MinimalHeightTrees310 {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();
        if(n == 1){
            result.add(0);
            return result;
        }

        List<Integer>[] connections = new ArrayList[n];
        for(int i=0; i<n; i++){
            connections[i] = new ArrayList<Integer>();
        }
        for(int[] edge : edges){
            connections[edge[0]].add(edge[1]);
            connections[edge[1]].add(edge[0]);
        }
        LinkedList<Integer> leaf = new LinkedList<Integer>();
        addAllLeafNode(connections, leaf);

        for(int removed = 0; removed + leaf.size() < n; removed++){
            int parent = detachChild(leaf.poll(), connections);
            // we detach all the leaf child, and go on to add new leaf nodes into the next batch queue.
            // until when we find that next batch we find that removed + leaf == n, which indicates this is the last batch
            if(leaf.isEmpty()){
                addAllLeafNode(connections, leaf);
                if(leaf.isEmpty()){
                    // after add, it's still nothing, then last remove it also remove the root's last node.
                    leaf.add(parent);
                    return leaf;
                }
            }
        }
        // when it's done, nodes with last batch will be left in the leaf node.
        return leaf;
    }

    private boolean isLeaf(int i, List<Integer>[] connections){
        return connections[i] != null && connections[i].size() == 1;
    }

    private void addAllLeafNode(List<Integer>[] connections, Queue<Integer> leaf){
        for(int i=0; i< connections.length; i++){
            if(isLeaf(i, connections)){
                leaf.offer(i);
            }
        }
    }

    // given child, remove itself
    private int detachChild(int child, List<Integer>[] connections){
        // remove child relation and get it's parent
        int parent = connections[child].remove(0);
        // detach
        // need to cast to Integer as it's overloaded by method list.remove(int index)
        // we need to specify to call list.remove(Object o) method.
        connections[parent].remove((Integer) child);

        return parent;
    }
}
