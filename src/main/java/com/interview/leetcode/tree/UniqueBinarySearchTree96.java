package com.interview.leetcode.tree;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 * <p>
 * For example,
 * Given n = 3, there are a total of 5 unique BST's.
 * <p>
 *      1         3     3      2      1
 *        \       /     /      / \      \
 *        3     2     1      1   3      2
 *      /     /       \                 \
 *     2     1         2                 3
 *
 * @author: Vincent
 * @since:10:42 PM, 18/7/2016
 */
public interface UniqueBinarySearchTree96 {
    int numTrees(int n);
}
