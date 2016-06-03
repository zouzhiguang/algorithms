package com.interview.algorithms.searching;

public class TreeNode<Key extends Comparable<Key>, Value> implements Comparable<TreeNode<Key, Value>>
{
    public static final boolean RED = true;
    public static final boolean BLACK = false;
    public TreeNode<Key, Value> left, right;
    public Key key;
    public Value value;
    public boolean color;
    public int counter;

    public TreeNode(Key key, Value value, boolean color, int counter)
    {
        this.key = key;
        this.value = value;
        this.color = color;
        this.counter = counter;
    }

    @Override
    public int compareTo(TreeNode<Key, Value> o)
    {
        return o == null || o.key == null ? 1 : key.compareTo(o.key);
    }

    public static boolean isRed(TreeNode node){
        return node != null && node.color;
    }
}
