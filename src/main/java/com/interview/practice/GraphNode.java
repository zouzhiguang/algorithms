package com.interview.practice;

import java.util.Set;

public class GraphNode{
	public int val;
	public Set<GraphNode> neighbours;

	public GraphNode(int val){
		this.val = val;
	}
}
