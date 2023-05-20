package graphs;

import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

public class SingleSourceReachablity extends BFS{
	
	
	@Override
	public void BFS(NetworkGraph adj, GraphVertex s ) {
		super.BFS(adj, s);
	}
	
	
	public boolean BFS(NetworkGraph adj, GraphVertex source, GraphVertex destination) {
		
		if (source.equals(destination))
			return true;
		
		GraphVertex s = source;
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
					if (v.equals(destination))
						return true;
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
		
		return false;
	}

}
