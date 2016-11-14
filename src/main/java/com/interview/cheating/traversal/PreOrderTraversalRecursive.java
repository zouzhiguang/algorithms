package com.interview.cheating.traversal;

import java.util.ArrayList;
import java.util.List;

/**
 * Root -> Left -> right
 */
public class PreOrderTraversalRecursive implements Traversal {
    @Override
    public List<Integer> traverse(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traverse(root, result);

        return result;
    }

    private void traverse(TreeNode root, List<Integer> result) {
        if(root == null) return;
        result.add(root.val);
        traverse(root.left, result);
        traverse(root.right, result);
    }
}
