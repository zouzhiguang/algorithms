package com.interview.cheating.traversal;

import java.util.ArrayList;
import java.util.List;

/**
 * Left -> Root -> Right
 */
public class InOrderTraversalRecursive implements Traversal {
    @Override
    public List<Integer> traverse(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traverse(root, result);
        return result;
    }

    private void traverse(TreeNode root, List<Integer> result) {
        if(root == null) return;
        traverse(root.left, result);
        result.add(root.val);
        traverse(root.right, result);
    }
}
