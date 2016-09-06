package com.interview.leetcode.tree;

/**
 * Given a binary tree
 * struct TreeLinkNode {
 *  TreeLinkNode *left;
 *  TreeLinkNode *right;
 *  TreeLinkNode *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * Initially, all next pointers are set to NULL.
 * Note:
 * You may only use constant extra space.
 * You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
 *
 * @see <a href="https://leetcode.com/problems/populating-next-right-pointers-in-each-node/">116. Populating Next Right Pointers in Each Node<a/>
 */
public interface PopulatingNextRightPointer116
{
    void connect(TreeLinkNode root);
}
