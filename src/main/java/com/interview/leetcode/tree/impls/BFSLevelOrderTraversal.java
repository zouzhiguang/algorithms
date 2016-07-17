package com.interview.leetcode.tree.impls;

import com.interview.leetcode.tree.BFSTraversal;
import com.interview.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Flat return is just same with Pre-Order algorithms, would here implement the LevelOrderTraverse
 * which return each level (layer) as a separate list to the result.
 * eg, [1,2,3,4,5,6,7] return as: [[1],[2,3],[4,5,6,7]]....
 *
 * @author: Vincent
 * @since:8:56 AM, 17/7/2016
 */
public class BFSLevelOrderTraversal<T> extends PreOrderTraversalIteration<T> implements BFSTraversal<T> {

    @Override
    public List<List<T>> traverseLevel(TreeNode<T> root) {
        Queue<TreeNode<T>> queue = new LinkedList<>();
        List<List<T>> result = new ArrayList<>();
        if (root == null) return result;
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<T> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode<T> node = queue.poll();
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
                level.add(node.val);
            }
            result.add(level);
        }

        return result;
    }
}
