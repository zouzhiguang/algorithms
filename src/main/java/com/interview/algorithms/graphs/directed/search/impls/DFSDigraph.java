package com.interview.algorithms.graphs.directed.search.impls;

import com.interview.algorithms.data.structures.Stack;
import com.interview.algorithms.data.structures.impls.ResizingArrayStack;
import com.interview.algorithms.graphs.directed.search.Digraph;

/**
 * Depth first search for direct graph.
 *
 * @author: Vincent
 * @since:11:01 AM, 4/6/2016
 */
public class DFSDigraph extends Digraph {

    public DFSDigraph(int V) {
        super(V);
    }

    @Override
    public Digraph newInstance() {
        return new DFSDigraph(V());
    }

    @Override
    public void search(int s) {
        Stack<Integer> stack = new ResizingArrayStack<>();
        marked[s] = true;
        stack.push(s);

        while (!stack.isEmpty()){
            Integer v = stack.pop();
            adj(v).forEach(x ->{
                if(!marked(x)){
                    marked[x] = true;
                    edgeTo[x] = v;
                    stack.push(x);
                }
            });
        }
    }
}
