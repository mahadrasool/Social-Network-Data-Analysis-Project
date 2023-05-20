package graphs;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

public class BFS extends GraphTraversal{
	
	
	/**
	 * BFS will only visit vertices that are reachable from source vertex
	 * BFS will be converted to full BFS, by looping over all vertices, i.e taking each vertex as source vertex s
	 * It is useful to solve reachability problem form source vertex s, if weights are linear or unweighted.
	 * Running time of this algorithm is O(|V| + |E|)
	 * @param adj
	 * @param s
	 */
	public void BFS(NetworkGraph adj, GraphVertex s) {
		
		super.Initialize_Single_Source(adj, s);				// O(|V|)
		/*
		 * Making Source vertex visited
		 */
		s.color = "gray";
		s.distance = 0;
		s.parent = null;
		System.out.println("Source Vertex Visited: " + s.getKey());
		/*
		 * Creating queue and enqueing source vertex to it
		 */
		LinkedBlockingQueue<Vertex> Q = new LinkedBlockingQueue<>();
		Q.add(s);
		
		
		/*
		 * Running loop until queue become empty
		 * i.e. visitng all vertices but at max once
		 */
		while (Q.size() != 0) {
			
			GraphVertex u = (GraphVertex) Q.remove();
			ArrayList<GraphVertex> adjacents = u.getNeighbours();
			//System.out.println(u.getKey() + " has neighbours " +adjacents.size());
			
			for (GraphVertex v: adjacents) {			// O(|E|)
				
				if (v.color.equals("white")) {
					//System.out.println("Vertex Visited: " + v.getKey());
					v.color = "gray";
					v.distance = u.distance + 1;
					v.parent = u;
					Q.add(v);
					//System.out.println("Queue size is " + Q.size());
				}
			}
			u.color = "black";
			
		}
		
	}
	
	
	
	/*
	 * Computing path from s to v and printing it
	 * (s,v)
	 */
	public void printPath(NetworkGraph adj, GraphVertex s, GraphVertex v) {
		if (v.equals(s))
			System.out.println(s.getKey());
		else if (v.parent == null)
				System.out.println("No path exists");
		else
			printPath(adj, s, v.parent);
		
		System.out.println(v.getKey());
	}

}
