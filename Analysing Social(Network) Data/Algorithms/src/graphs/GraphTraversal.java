package graphs;

public class GraphTraversal {

	private int vertices;
	
	public GraphTraversal() {
		this.vertices = 0;
	}

	public void Initialize_Single_Source(NetworkGraph adj, GraphVertex s) {
		
		int sizeOfAdj = adj.getAdj().size();
		
		/*
		 * Initializing Single Source Vertex
		 * O(|V|) time work
		 */
		for (int i = 0; i < sizeOfAdj; i++) {			// O(|V|)
				GraphVertex V = adj.getAt(i).v;
				V.color = "white";
				V.parent = null;
				V.distance = 999999999;
				this.vertices++;	
				//System.out.println("Making white vertex " + V.getKey());
		}
		
	}
	
}
