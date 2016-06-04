package com.interview.algorithms.graphs.directed.shortestpath;

/**
 * @author: Vincent
 * @since:10:51 AM, 4/6/2016
 */
public class DirectedEdge {
    private final int v, w;
    private final double weight;

    public DirectedEdge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int from(){
        return v;
    }

    public int to() {
        return w;
    }

    public double weight(){
        return weight;
    }
}
