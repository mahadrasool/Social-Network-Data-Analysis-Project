package graphs;

import java.util.ArrayList;

public class EdgesList {

	private int vertexCount;
	GraphVertex v;
	private ArrayList<GraphVertex> adjacents;
	
	public EdgesList() {
		
		v = new GraphVertex();
		adjacents = new ArrayList<GraphVertex>();
	}
	
	
	public ArrayList<GraphVertex> getAdj() {
		return adjacents;
	}
	
	public void addVertex(int key) {
		GraphVertex v = new GraphVertex();
		v.setKey(key);
		adjacents.add(v);
		this.vertexCount++;
	}
	
	public void addVertex(GraphVertex v) {
		adjacents.add(v);
		this.vertexCount ++;
		
	}

	public int getVertexCount() {
		return vertexCount;
	}

		
}
