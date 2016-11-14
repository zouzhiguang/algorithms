package com.interview.cheating.traversal;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Vincent
 * @since:10:25 PM, 14/11/2016
 */
public class PostOrderRecursiveRecursive implements  Traversal{
    @Override
    public List<Integer> traverse(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traverse(root, result);
        return result;
    }

    private void traverse(TreeNode root, List<Integer> result) {
        if(root == null) return;
        traverse(root.left, result);
        traverse(root.right, result);
        result.add(root.val);
    }
}
