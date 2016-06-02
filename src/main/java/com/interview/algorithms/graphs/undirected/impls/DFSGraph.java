package com.interview.algorithms.graphs.undirected.impls;

import com.interview.algorithms.data.structures.Stack;
import com.interview.algorithms.data.structures.impls.ResizingArrayStack;
import com.interview.algorithms.graphs.undirected.Graph;

public class DFSGraph extends Graph
{
    private Integer startPointVertex;

    public DFSGraph(int V)
    {
        super(V);
    }

    @Override
    public void search(int s)
    {
        startPointVertex = s;
        marked[s] = true;
        for (int w: adj(s)){
            if(!marked(w)){
                edgeTo[w] = s;
                search(w);
            }
        }
    }

    @Override
    public boolean marked(int v)
    {
        return marked[v];
    }

    @Override
    public boolean hasPathTo(int v)
    {
        return marked[v];
    }

    @Override
    public Iterable<Integer> pathTo(int v)
    {
        if(!hasPathTo(v)) return null;
        Stack<Integer> path = new ResizingArrayStack<>();
        // push self first
        path.push(v);
        // find the starting point and push it. Similar to the reverse function of di-graph
        while (edgeTo[v] != null){
            path.push(edgeTo[v]);
            v = edgeTo[v];
        }
        return path;
    }

    @Override
    public void caculateCC()
    {
        Integer previousCursor = startPointVertex;
        try
        {
            // travel all node to use dfs to calculate all connected nodes....
            for (int i = 0; i < V(); i ++){
                if (!marked(i)){
                    // if it has been calculated before, then we don't need to calculate again.
                    search(i);
                    counter ++;
                }
            }
        }
        finally
        {
            // we reset the cursor after the calculation
            startPointVertex = previousCursor;
        }

    }

}
