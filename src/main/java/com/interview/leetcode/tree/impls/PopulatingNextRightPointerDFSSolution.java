package com.interview.leetcode.tree.impls;

import com.interview.leetcode.tree.PopulatingNextRightPointer116;
import com.interview.leetcode.tree.TreeLinkNode;

/**
 * @author: vzou
 * *
 * @since: 9/5/2016.
 */
public class PopulatingNextRightPointerDFSSolution implements PopulatingNextRightPointer116
{
    @Override
    public void connect(TreeLinkNode root)
    {
        if (root == null || root.left == null)
        {
            return;
        }

        TreeLinkNode left = root.left;
        TreeLinkNode right = root.right;

        while (left != null)
        {
            left.next = right;
            left = left.right;
            right = right.left;
        }

        connect(root.left);
        connect(root.right);
    }
}
