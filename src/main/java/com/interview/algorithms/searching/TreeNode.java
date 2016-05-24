package com.interview.algorithms.searching;

public class TreeNode<Key extends Comparable<Key>, Value> implements Comparable<TreeNode>
{
    public static final boolean RED = true;
    public static final boolean BLACK = false;
    public TreeNode left, right;
    public Key key;
    public Value value;
    public boolean color;
    public int counter;

    public TreeNode(Key key, Value value)
    {
        this.key = key;
        this.value = value;
    }

    @Override
    public int compareTo(TreeNode o)
    {
        return o == null || o.key == null ? 1 : key.compareTo((Key) o.key);
    }

    public static boolean isRed(TreeNode node){
        return node != null && node.color;
    }
}
