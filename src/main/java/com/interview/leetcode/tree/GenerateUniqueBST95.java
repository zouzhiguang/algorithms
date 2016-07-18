package com.interview.leetcode.tree;

import java.util.List;

/**
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 * <p>
 * For example,
 * Given n = 3, your program should return all 5 unique BST's shown below.
 *      1         3     3      2      1
 *        \       /     /      / \      \
 *        3     2     1      1   3      2
 *      /     /       \                 \
 *     2     1         2                 3
 *
 * @author: Vincent
 * @since:10:44 PM, 18/7/2016
 */
public interface GenerateUniqueBST95 {
    List<TreeNode> generateTrees(int n);
}
