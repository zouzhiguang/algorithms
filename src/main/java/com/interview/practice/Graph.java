package com.interview.practice;

import java.util.*;

public class Graph {
	public List<Integer> bfsTraversal(GraphNode start){
		Queue<GraphNode> queue = new LinkedList<>();
		Set<GraphNode> visited = new HashSet<>();
		List<Integer> result = new ArrayList<>();
		queue.add(start);

		while(!queue.isEmpty()){
			GraphNode node = queue.poll();
			for(GraphNode neighbour : node.neighbours){
				if(!visited.contains(neighbour)){
					visited.add(neighbour);
					queue.add(neighbour);
				}
			}

			result.add(node.val);
		}

		return result;
	}

	public List<Integer> dfsTraversal(GraphNode start){
		Stack<GraphNode> stack = new Stack<>();
		Set<GraphNode> visited = new HashSet<>();
		List<Integer> result = new ArrayList<>();
		stack.push(start);

		while(!stack.isEmpty()){
			GraphNode node = stack.pop();
			for(GraphNode neighbour : node.neighbours){
				if(!visited.contains(neighbour)){
					visited.add(neighbour);
					stack.push(neighbour);
				}
			}

			result.add(node.val);
		}

		return result;
	}

}
