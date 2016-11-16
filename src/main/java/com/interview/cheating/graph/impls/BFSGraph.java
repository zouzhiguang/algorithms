package com.interview.cheating.graph.impls;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import com.interview.cheating.graph.Graph;
import com.interview.cheating.graph.GraphNode;

public class BFSGraph implements Graph
{
    @Override
    public List<GraphNode> traverse(GraphNode start)
    {
        List<GraphNode> result = new ArrayList<>();
        if(start == null) return result;
        Queue<GraphNode> queue = new LinkedList<>();
        Set<GraphNode> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);
        while (!queue.isEmpty()){
            GraphNode pop = queue.poll();
            result.add(pop);
            if(pop.getNeighbours() == null) continue;
            pop.getNeighbours().stream().filter(node -> !visited.contains(node)).forEach(node ->{
                visited.add(node);
                queue.offer(node);
            });
        }

        return result;
    }
}
