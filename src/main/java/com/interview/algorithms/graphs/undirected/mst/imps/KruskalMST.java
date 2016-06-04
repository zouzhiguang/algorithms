package com.interview.algorithms.graphs.undirected.mst.imps;

import com.interview.algorithms.graphs.undirected.mst.Edge;
import com.interview.algorithms.graphs.undirected.mst.EdgeWeightedUndirectGraph;

/**
 * @author: Vincent
 * @since:10:57 AM, 4/6/2016
 */
public class KruskalMST extends EdgeWeightedUndirectGraph{

    public KruskalMST(int v) {
        super(v);
    }

    @Override
    public void generateMST() {

    }

    @Override
    public Iterable<Edge> mstEdges() {
        return null;
    }

    @Override
    public double weight() {
        return 0;
    }
}
