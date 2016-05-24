package com.interview.algorithms.searching.impls;

import com.interview.algorithms.searching.OrderedSymbolTable;
import com.interview.algorithms.searching.TreeNode;

/**
 * @author: vzou
 * *
 * @since: 5/23/2016.
 */
public class BlackRedBinarySearchTree<Key extends Comparable<Key>, Value> implements OrderedSymbolTable<Key, Value>
{
    public TreeNode<Key, Value> root;

    @Override
    public Key min()
    {
        TreeNode<Key, Value> node = root;
        while (node != null){
            if(node.left == null){
                return node.key;
            }
        }

        return null;
    }

    @Override
    public Key max()
    {
        TreeNode<Key, Value> node = root;
        while (node != null){
            if(node.right == null){
                return node.key;
            }
        }

        return null;
    }

    @Override
    public Key floor(Key key)
    {
        return null;
    }

    @Override
    public Key ceiling(Key key)
    {
        return null;
    }

    @Override
    public int rank(Key key)
    {
        return 0;
    }

    @Override
    public Key select(int k)
    {
        return null;
    }

    @Override
    public Value deleteMin()
    {
        return null;
    }

    @Override
    public Value deleteMax()
    {
        return null;
    }

    @Override
    public Iterable<Key> keys(Key low, Key high)
    {
        return null;
    }

    @Override
    public void put(Key key, Value value)
    {


    }

    @Override
    public Value get(Key key)
    {
        return null;
    }

    @Override
    public Value delete(Key key)
    {
        return null;
    }

    @Override
    public boolean contains(Key key)
    {
        return false;
    }

    @Override
    public boolean isEmpty()
    {
        return false;
    }

    @Override
    public int size()
    {
        return 0;
    }

    @Override
    public Iterable<Key> keys()
    {
        return null;
    }
}
