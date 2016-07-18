package com.interview.leetcode.tree;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * <p>
 * According to the definition of LCA on Wikipedia:
 * “The lowest common ancestor is defined between two nodes v and w as the lowest node in T
 * that has both v and w as descendants (where we allow a node to be a descendant of itself).”
 *
 * @author: Vincent
 * @since:10:41 PM, 18/7/2016
 */
public interface LowestCommonAncestorOfBinaryTree236 {
    TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q);
}
