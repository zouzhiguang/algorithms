package com.interview.cheating.graph;

import java.util.Set;

public class GraphNode
{
    public final int      val;
    public Set<GraphNode> neighbours;

    public GraphNode(int val)
    {
        this.val = val;
    }

    public int getVal()
    {
        return val;
    }

    public Set<GraphNode> getNeighbours()
    {
        return neighbours;
    }

    public void setNeighbours(Set<GraphNode> neighbours)
    {
        this.neighbours = neighbours;
    }
}
