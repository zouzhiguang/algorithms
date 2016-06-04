package com.interview.algorithms.graphs.directed.search;

import java.util.Objects;
import com.interview.algorithms.data.structures.Bag;
import com.interview.algorithms.data.structures.impls.LinkedListBag;

/**
 * @author: vzou
 * *
 * @since: 6/2/2016.
 */
public abstract class Digraph
{
    private final int        V; // number of vertices
    private       int            E; // number of edges
    private       Bag<Integer>[] adj; // adjacency lists

    protected boolean[] marked;
    protected Integer[] edgeTo;
    protected int       counter;
    protected Integer[] connectedComponent;

    public Digraph(int V)
    {
        this.V = V;
        this.E = 0;
        adj = new Bag[V]; // Create array of lists.
        for (int v = 0; v < V; v++) // Initialize all lists
            adj[v] = new LinkedListBag<>(); // to empty.

        marked = new boolean[V];
        edgeTo = new Integer[V];
        connectedComponent = new Integer[V];
    }

    public int V()
    {
        return V;
    }

    public int E()
    {
        return E;
    }

    public void addEdge(int v, int w)
    {
        adj[v].add(w); // Add w to v’s list.
        E++;
    }

    public Iterable<Integer> adj(int v)
    {
        return adj[v];
    }

    public Digraph reverse(){
        Digraph rev = newInstance();
        for (int i = 0; i < V; i++){
            final int currentV = i;
            adj(i).forEach( v -> rev.addEdge(v, currentV));
        }

        return rev;
    }

    public abstract Digraph newInstance();

    public abstract void search(int s);

    /**
     * Check if v is connected so far
     *
     * @param v
     * @return
     */
    public boolean marked(int v){
        return marked[v];
    }

    /**
     * is there a path from the given start point to the vertex V?
     *
     * @param v
     * @return
     */
    public boolean hasPathTo(int v){
        return marked(v);
    }


    /**
     * Calculate the connected component.
     */
    public void caculateCC(){
        for (int i = 0; i < V(); i++){
            if(!marked(i)){
                counter ++;
                search(i);
            }
        }
    }

    /**
     * is a and b connected? by using graph search instead of union-find?
     *
     * @param a
     * @param b
     * @return
     */
    public boolean connected(int a, int b)
    {
        assert a < V && b < V;
        return Objects.equals(connectedComponent[a], connectedComponent[b]);
    }

    /**
     * how many connected component so far?
     *
     * @return
     */
    public final int count()
    {
        return counter;
    }

    /**
     * get the connected component identifier for the given vertex
     *
     * @return
     */
    public int identifier(int vertex)
    {
        assert vertex < count();
        return connectedComponent[vertex];
    }
}
