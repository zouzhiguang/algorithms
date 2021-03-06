package com.interview.leetcode.tree.impls;

import com.interview.leetcode.tree.Traversal;
import com.interview.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Vincent
 * @since:6:24 AM, 17/7/2016
 */
public class InOrderTraversalRecursive<T> implements Traversal<T> {
    @Override
    public List<T> traverse(TreeNode<T> root) {
        List<T> result = new ArrayList<>();
        traverse(root, result);
        return result;
    }

    private void traverse(TreeNode<T> root, List<T> result) {
        if (root == null) {
            return;
        }

        if (root.left != null)
            traverse(root.left, result);

        result.add(root.val);

        if (root.right != null)
            traverse(root.right, result);
    }
}
