package com.interview.leetcode.tree.impls;

import com.interview.leetcode.tree.LowestCommonAncestorOfBST235;
import com.interview.leetcode.tree.TreeNode;

/**
 * @author: vzou
 * *
 * @since: 7/19/2016.
 */
public class LowestCommonAncestorOfBST implements LowestCommonAncestorOfBST235
{
    @Override
    public TreeNode lowestCommonAncestor(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q)
    {
        if (root.val > p.val && root.val > q.val)
        {
            return lowestCommonAncestor(root.left, p, q);
        }
        else if (root.val < p.val && root.val < q.val)
        {
            return lowestCommonAncestor(root.right, p, q);
        }

        if (root == p)
        {
            return p;
        }

        if (root == q)
        {
            return q;
        }

        return root;
    }
}
