package com.interview.algorithms.princeton;

/**
 * @author: Vincent
 * @since:4:00 PM, 8/5/16
 */
public abstract class UnionFindProblem
{
    protected int[] id;
    protected int   size;

    public UnionFindProblem(int N)
    {
        id = new int[N];
        this.size = N;
        for (int i = 0; i < N; i++)
        {
            id[i] = i;
        }
    }

    /**
     * check if given two index are connected or not
     *
     * @param a first item index
     * @param b second item index
     * @return
     */
    public abstract boolean isConnected(int a, int b);

    /**
     * connect the given two item in the list index
     *
     * @param a index of the first item
     * @param b index of the second item
     */
    public abstract void union(int a, int b);

    public static class QuickFind extends UnionFindProblem
    {

        public QuickFind(int N)
        {
            super(N);
        }

        @Override
        public boolean isConnected(int a, int b)
        {
            return id[a] == id[b];
        }

        @Override
        public void union(int a, int b)
        {
            int value = id[a];
            for (int i = 0; i < size; i++)
            {
                if (id[i] == value)
                {
                    id[i] = id[b];
                }
            }
        }
    }

    public static class QuickUnion extends UnionFindProblem
    {

        public QuickUnion(int N)
        {
            super(N);
        }

        @Override
        public boolean isConnected(int a, int b)
        {
            return root(a) == root(b);
        }

        @Override
        public void union(int a, int b)
        {
            id[root(a)] = root(b);
        }

        public int root(int a)
        {
            if (id[a] == a)
            {
                return a;
            }
            return root(id[a]);
        }
    }

    public static class WeightedUnion extends QuickUnion
    {
        private int[] size;

        public WeightedUnion(int N)
        {
            super(N);
            size = new int[N];
            for (int i = 0; i < N; i++)
            {
                size[i] = 1;
            }
        }

        @Override
        public void union(int a, int b)
        {
            int i = root(a);
            int j = root(b);
            if (i == j)
            {
                return;
            }

            if (size[i] < size[j])
            {
                size[i] += size[j];
                id[i] = j;
            }
            else
            {
                size[j] += size[i];
                id[j] = i;
            }
        }
    }

    public static class WeightedUnionWithPathCompression extends WeightedUnion
    {

        private int[] size;

        public WeightedUnionWithPathCompression(int N)
        {
            super(N);
        }

        @Override
        public int root(int a)
        {
            while(id[a] != a){
                id[a] = id[id[a]];
                a = id[a];
            }
            return a;
        }
    }
}
