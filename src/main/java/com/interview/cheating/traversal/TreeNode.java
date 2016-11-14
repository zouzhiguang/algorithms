package com.interview.cheating.traversal;

/**
 * @author: Vincent
 * @since:9:22 PM, 14/11/2016
 */
public class TreeNode {
    public TreeNode left, right;
    public final int val;
    public TreeNode(int val){
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public int getVal() {
        return val;
    }

    /**
     * Build the Tree with Level-Order with given char array. '#' means it's null.
     * @param tree tree String
     * @return the tree root node
     */
    public static TreeNode fromArray(String tree){
        // TODO
        return null;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}
