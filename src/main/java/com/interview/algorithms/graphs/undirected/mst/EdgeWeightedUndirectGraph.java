package com.interview.algorithms.graphs.undirected.mst;

import com.interview.algorithms.data.structures.Bag;
import com.interview.algorithms.data.structures.impls.LinkedListBag;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Vincent
 * @since:11:48 AM, 4/6/2016
 */
public abstract class EdgeWeightedUndirectGraph {
    private final int V;
    private Bag<Edge>[] adj;
    private int E;

    public EdgeWeightedUndirectGraph(int v) {
        this.V = v;
        E = 0;
        adj = new Bag[v];

        for (int i = 0; i < V; i ++){
            adj[i] = new LinkedListBag<>();
        }
    }

    public int V() {
        return V;
    }

    public int E(){
        return E;
    }

    public void addEdge(Edge edge){
        E ++;
        int v = edge.either();
        int w = edge.other(v);

        adj[v].add(edge);
        adj[w].add(edge);
    }

    public Iterable<Edge> adj(int v){
        return adj[v];
    }

    public Iterable<Edge> edges(){
        List<Edge> result = new ArrayList<>(E);
        for (int i = 0; i < V(); i ++){
            for (Edge edge : adj(i)) {
                if(edge.either() == i){
                    // ensure it's 'originates' from i
                    result.add(edge);
                }
            }
        }

        return result;
    }

    public abstract void generateMST();

    public abstract Iterable<Edge> mstEdges();

    public abstract double weight();

}
