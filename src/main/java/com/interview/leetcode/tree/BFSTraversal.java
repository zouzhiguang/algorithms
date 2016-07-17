package com.interview.leetcode.tree;

import java.util.List;

/**
 * @author: Vincent
 * @since:8:53 AM, 17/7/2016
 */
public interface BFSTraversal<T> extends Traversal<T> {
    List<List<T>> traverseLevel(TreeNode<T> root);
}
