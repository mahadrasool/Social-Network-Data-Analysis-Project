package graphs;

import bst.BST;
import bst.GraphNode;

public class FindEgonet implements Egonet<GraphVertex> {
	
	private GraphVertex vertexNetwork;
	
	public FindEgonet() {
		this.vertexNetwork = new GraphVertex();
	}

	public void getEgonet(NetworkGraph adj, int center) {
		
		BST bst = adj.getBst();
		GraphNode node = bst.searchNode(bst.getRoot(), center);
		GraphVertex v = node.vertex;
		
		if (v != null)
			this.getEgonet(adj, v);
		
	}
	
	
	@Override 
	/**
	 * Finding egonet of a specific vertex in the graph,
	 */
	public NetworkGraph getEgonet(NetworkGraph adj, GraphVertex center) {
		
		for (GraphVertex v: center.getNeighbours()) {
			this.vertexNetwork.addNeighbours(v);
			
		}
		
		for (GraphVertex u: center.getNeighbours()) {
			for (GraphVertex v: this.vertexNetwork.getNeighbours()) {
				if (u == v)
					this.vertexNetwork.addNeighbours(u);
			}
		}
		

		
		return null;		
	}

}
