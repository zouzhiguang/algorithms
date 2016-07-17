package com.interview.leetcode.tree;

import java.util.List;

/**
 * Interface for Pre-order, In-Order and Post-order traversal for binary tree algorithms.
 *
 * @author: Vincent
 * @since:6:08 AM, 17/7/2016
 */
public interface Traversal<T> {
    List<T> traverse(TreeNode<T> root);
}
