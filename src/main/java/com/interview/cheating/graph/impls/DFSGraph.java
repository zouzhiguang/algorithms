package com.interview.cheating.graph.impls;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import com.interview.cheating.graph.Graph;
import com.interview.cheating.graph.GraphNode;

/**
 * @author: vzou
 * *
 * @since: 11/16/2016.
 */
public class DFSGraph implements Graph
{
    @Override
    public List<GraphNode> traverse(GraphNode start)
    {
        List<GraphNode> result = new ArrayList<>();
        if(start == null) return result;
        Stack<GraphNode> stack = new Stack<>();
        Set<GraphNode> visited = new HashSet<>();
        stack.push(start);
        visited.add(start);
        while (!stack.isEmpty()){
            GraphNode pop = stack.pop();
            result.add(pop);
            if(pop.getNeighbours() == null) continue;
            pop.getNeighbours().stream().filter(node -> !visited.contains(node)).forEach(node ->{
                visited.add(node);
                stack.push(node);
            });
        }

        return result;
    }
}
