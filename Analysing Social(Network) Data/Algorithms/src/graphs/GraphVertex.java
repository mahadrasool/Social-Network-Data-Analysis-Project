package graphs;

import java.util.ArrayList;

public class GraphVertex implements Vertex {

	private int key;
	private boolean visited;
	private ArrayList<GraphVertex> neighbours;
	private ArrayList<GraphVertex> community;
	//private ArrayList<Integer> weights;
	String color;
	int distance;
	int finishingTime;
	GraphVertex parent;
	
	public GraphVertex() {
		neighbours = new ArrayList<GraphVertex>();
		community = new ArrayList<GraphVertex>();
		this.key = 0;
		this.visited = false;
		this.color = "white";
		this.distance = 999999999;		// Initializing to infinity, in context of java the largest value 
		this.parent = null;
		//weights = new ArrayList<Integer>();
		this.finishingTime = 0;
	}
	
	

	public ArrayList<GraphVertex> getCommunity() {
		return community;
	}
	
	
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public boolean isVisited() {
		return visited;
	}
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
	public ArrayList<GraphVertex> getNeighbours() {
		return neighbours;
	}


	public void addNeighbours(GraphVertex neighbours) {
		this.neighbours.add(neighbours);
	}

	public void addCommunityMember(GraphVertex v) {
		community.add(v);
	}

	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (o.getClass() != this.getClass())
			return false;
		
		if (((GraphVertex) o).getKey() == this.getKey()) //&& o.hashCode() == this.hashCode())
			return true;
		else
			return false;
	}
	
	
}


