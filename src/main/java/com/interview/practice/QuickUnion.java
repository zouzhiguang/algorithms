package com.interview.practice;

import com.interview.algorithms.princeton.UnionFindProblem;

/**
 * @author: vzou
 * *
 * @since: 9/13/2016.
 */
public class QuickUnion extends UnionFindProblem
{
    public QuickUnion(int N)
    {
        super(N);
    }

    @Override
    public boolean isConnected(int a, int b)
    {
        int cursor = b;
        while(id[cursor] != cursor) {
            if(id[cursor] == id[a]) return true;
            cursor = id[b];
        }

        return false;
    }

    @Override
    public void union(int a, int b)
    {
        id[b] = id[a];
    }
}
