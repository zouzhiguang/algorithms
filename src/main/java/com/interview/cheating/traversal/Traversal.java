package com.interview.cheating.traversal;

import java.util.List;

/**
 * @author: Vincent
 * @since:9:23 PM, 14/11/2016
 */
public interface Traversal {
    /**
     * Traversal given root by given order implementation
     * @param root the root of the tree
     * @return the value based on the visiting sequence.
     */
    List<Integer> traverse(TreeNode root);
}
