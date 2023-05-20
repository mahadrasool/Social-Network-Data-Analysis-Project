package mit;

import java.util.Scanner;

//import graphs.AdjacencyList;

public class Graph {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter the number of vertices you want to add: ");
		int vertices = 4; //in.nextInt();
		
		 Adjacency adj[] = new Adjacency[vertices];
		 
		 for (int i = 0; i < vertices; i++) {
			 adj[i] = new Adjacency();
		 }
	
		 
		 adj[0].getArrayList().add(1);
		 adj[0].getArrayList().add(2);
		 adj[0].getArrayList().add(3);
		 adj[0].getArrayList().add(4);
		 
		 adj[1].getArrayList().add(2);
		 adj[1].getArrayList().add(3);
		 adj[1].getArrayList().add(1);
		 adj[1].getArrayList().add(4);
		 
		 
		 adj[2].getArrayList().add(3);
		 adj[2].getArrayList().add(4);
		 adj[2].getArrayList().add(2);
		 adj[2].getArrayList().add(1);
		 
		 
		 adj[3].getArrayList().add(4);
		 adj[3].getArrayList().add(3);
		 adj[3].getArrayList().add(2);
		 adj[3].getArrayList().add(1);
		 
		 DFS dfs = new DFS();
		 dfs.dfs(adj);
		 
	}
}
