package com.interview.leetcode.tree;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 * <p>
 * For example:
 * Given the below binary tree and sum = 22,
 * <p>
 *          5
 *         / \
 *       4   8
 *      /   / \
 *     11  13  4
 *    /  \      \
 *  7    2      1
 *
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 * @author: Vincent
 * @since:10:46 PM, 18/7/2016
 */
public interface PathSum112 {
    boolean hasPathSum(TreeNode root, int sum);
}
