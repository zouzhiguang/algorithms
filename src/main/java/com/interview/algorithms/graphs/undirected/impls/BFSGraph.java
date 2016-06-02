package com.interview.algorithms.graphs.undirected.impls;

import com.interview.algorithms.data.structures.Queue;
import com.interview.algorithms.data.structures.impls.ResizingArrayQueue;

/**
 * @author: vzou
 * *
 * @since: 6/2/2016.
 */
public class BFSGraph extends DFSGraph
{
    public BFSGraph(int V)
    {
        super(V);
    }

    @Override
    public void search(int s)
    {
        Queue<Integer> queue = new ResizingArrayQueue<>();
        marked[s] = true;
        queue.enqueue(s);

        while (!queue.isEmpty()){
            Integer vertex = queue.dequeue();

            for (int w : adj(vertex)){
                if(!marked(w)){
                    edgeTo[w] = vertex;
                    marked[w] = true;
                    queue.enqueue(w);
                }
            }
        }
    }
}
