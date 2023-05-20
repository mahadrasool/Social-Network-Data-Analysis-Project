package graphs;

import java.util.ArrayList;

import bst.BST;
import bst.GraphNode;

public class NetworkGraph implements Graph<GraphVertex> {
	
	private int vertices;
	private int edges;
	private ArrayList<EdgesList> edgeList;
	private BST bst;
	
	public NetworkGraph() {
		 edgeList = new ArrayList<EdgesList>();
		 bst = new BST();
		 this.vertices = 0;
		 this.edges = 0;
	}
	
	
	public int getVertices() {
		return this.vertices;
	}
	
	public int getEdges() {
		return this.edges;
	}
	
	public EdgesList getAt(int index) {
		if (index >= 0 && index < edgeList.size())
			return edgeList.get(index);
		else
			return null;
	}
	
	public ArrayList<EdgesList> getAdj() {
		return edgeList;
	}

	
	public void addEdge(int vertexKey,int edgeKey) {
		
		/*
		 * (s,v) is denoting a edge pair in graph, using graphs notation
		 */
		//System.out.println(bst.getRoot());
		GraphNode vertexNode = bst.searchNode(bst.getRoot(), vertexKey);
		GraphNode edgeNode = bst.searchNode(bst.getRoot(), edgeKey);
		
		GraphVertex s = null;
		GraphVertex v = null;
	
		if (vertexNode == null)
			s = this.addVertex(vertexKey);
		else
			s = vertexNode.vertex;
		if (edgeNode == null)
			v = this.addVertex(edgeKey);
		else
			v = edgeNode.vertex;
		
		s.addNeighbours(v);
		//System.out.println("Ad");
		
		this.edges ++;
	}
	
	
	public GraphVertex addVertex(int key) {
		//System.out.println("Adding vertex " + key);
			GraphVertex v = new GraphVertex();
			EdgesList e = new EdgesList();
			e.v = v;
			edgeList.add(e);
			//System.out.println("Adjacency list size is: " + adj.size());
			v.setKey(key);
			bst.insert(v);
			v.setVisited(true);
			
			this.vertices++;
			return v;
	}
	
	public GraphVertex getFirstVertex() {
		return edgeList.get(0).v;
	}
	
	private EdgesList searchList(int key) {
		for (int i = 0; i < edgeList.size(); i++) {
			if (edgeList.get(i).v.getKey() == key)
				return edgeList.get(i);
		}
		return null;
	}


	public BST getBst() {
		return bst;
	}	

}
