package com.interview.leetcode.tree.impls;

import com.interview.leetcode.tree.DFSTraversal;
import com.interview.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: Vincent
 * @since:6:11 AM, 17/7/2016
 */
public class PreOrderTraversalIteration<T> implements DFSTraversal<T> {
    @Override
    public List<T> traverse(TreeNode<T> root) {
        Stack<TreeNode<T>> stack = new Stack<>();
        List<T> values = new ArrayList<>();
        if (root == null) {
            return values;
        }

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode<T> node = stack.pop();
            values.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return values;
    }
}
