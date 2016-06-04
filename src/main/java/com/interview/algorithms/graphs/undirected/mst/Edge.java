package com.interview.algorithms.graphs.undirected.mst;

/**
 * @author: Vincent
 * @since:10:49 AM, 4/6/2016
 */
public class Edge implements Comparable<Edge> {
    private final int v;
    private final int w;
    private final double weight;

    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double weight() {
        return weight;
    }

    public int either() {
        return v;
    }

    public int other(int v) {
        return v == this.v ? this.w : this.v;
    }

    @Override
    public int compareTo(Edge o) {
        return (int) (weight - o.weight);
    }
}
