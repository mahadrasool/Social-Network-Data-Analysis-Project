package graphs;

import stack.StackOfVertices;

public class SocialCommunities extends DFS{
	
	private int time ;
	
	public SocialCommunities() {
		this.time = 0;
	}
	
	
	public void stronglyConnectedComponents(NetworkGraph adj) {
		super.dfs(adj, true);
		
		super.Initialize_Single_Source(adj, adj.getFirstVertex());
		
		System.out.println("\nRunning DFS of trasnpose of G");
		StackOfVertices stack = super.getStack();
		
		for (int i = 0; i < stack.size(); i++) {
			GraphVertex v = stack.pop();
			super.dfs_Visit(v, false,true);
		}
	}
	
		
}
