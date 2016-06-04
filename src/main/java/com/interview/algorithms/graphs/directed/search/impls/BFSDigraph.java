package com.interview.algorithms.graphs.directed.search.impls;

import com.interview.algorithms.data.structures.Queue;
import com.interview.algorithms.data.structures.impls.ResizingArrayQueue;
import com.interview.algorithms.graphs.directed.search.Digraph;

import java.util.Arrays;

/**
 * @author: Vincent
 * @since:11:15 AM, 4/6/2016
 */
public class BFSDigraph extends Digraph {

    private int[] distanceTo;
    private int counter = 0;

    public BFSDigraph(int V) {
        super(V);
        distanceTo = new int[V()];
        Arrays.fill(distanceTo, Integer.MAX_VALUE);
    }

    @Override
    public Digraph newInstance() {
        return new BFSDigraph(V());
    }

    @Override
    public void search(int s) {
        Queue<Integer> queue = new ResizingArrayQueue<>();
        marked[s] = true;
        distanceTo[s] = 0;
        queue.enqueue(s);
        while (!queue.isEmpty()) {
            Integer v = queue.dequeue();

            adj(v).forEach(x -> {
                if (!marked(x)) {
                    edgeTo[x] = v;
                    connectedComponent[x] = counter;
                    marked[x] = true;
                    distanceTo[x] = distanceTo[v] + 1;
                    queue.enqueue(x);
                }
            });
        }
    }
}
