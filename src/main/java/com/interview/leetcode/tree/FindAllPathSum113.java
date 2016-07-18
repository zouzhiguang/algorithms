package com.interview.leetcode.tree;

import java.util.List;

/**
 *
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
 *    /  \    / \
 *  7    2   5  1
 *
 * return:
 *  [
 *      [5,4,11,2],
 *      [5,8,4,5]
 *  ]
 *
 * @author: Vincent
 * @since:10:49 PM, 18/7/2016
 */
public interface FindAllPathSum113 {
    List<List<Integer>> pathSum(TreeNode root, int sum);
}
