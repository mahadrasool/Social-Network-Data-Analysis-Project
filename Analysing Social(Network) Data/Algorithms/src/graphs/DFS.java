package graphs;

import java.util.ArrayList;

import stack.StackOfVertices;

public class DFS extends GraphTraversal {
	
	private int time;
	private StackOfVertices stack;
	
	public DFS() {
		this.time = 0;
		stack = new StackOfVertices();
	}

	
	public StackOfVertices getStack() {
		return this.stack;
	}
	
	
	/**
	 * Running full dfs on a graph with source vertex s
	 * @param adj
	 */
	public void dfs(NetworkGraph adj, boolean takeTranspose) {
		super.Initialize_Single_Source(adj, adj.getFirstVertex());		// O(|V|)
		
		
		for (int i = 0; i < adj.getVertices(); i++) { 		// O(|V|)
			GraphVertex u = adj.getAt(i).v;
			//System.out.println("Outside loop for source vertex: " + u.getKey() + " color: " + u.color);
			if (u.color.equals("white"))
			{
				System.out.println("Initializing for source vertex: " + u.getKey());
				dfs_Visit(u,takeTranspose,false);
			}
		}
		
	}
	
	/**
	 * Doing dfs on specific vertex using timestamp and color augmentation 
	 * Storing timetsmaps in the dfs
	 * For each vertex u E V u.d < u.f (finishingTime)
	 * TimeStamps provide useful information about graph structure and dfs behavior
	 * @RunTime O(|E|)
	 * @param adj
	 * @param u
	 */
	public void dfs_Visit(GraphVertex u, boolean takeTranspose, boolean makeSetOfCommunities) {
		this.time ++;
		u.distance = time;
		u.color = "gray";
		//System.out.println("Marking gray: " + u.getKey());
		
		for (GraphVertex v: u.getNeighbours()) {		// O(|E|)
			if (v.color.equals("white")) {
				//System.out.println("Visiting vertex: " + v.getKey());
				v.parent = u;
				if (makeSetOfCommunities)
					u.addCommunityMember(v);
				dfs_Visit(v,takeTranspose, makeSetOfCommunities);
			}
			
		}
		
		//System.out.println("Marking black: " + u.getKey());
		u.color = "black";
		
		/*
		 * If we want to take transpose of a graph
		 */
		if (takeTranspose)
			this.stack.push(u);
			
		this.time ++;
		u.finishingTime = this.time;
		
	}
	
}
