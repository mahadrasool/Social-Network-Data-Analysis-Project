package graphs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import bst.BST;
import bst.GraphNode;

public class CreateGraph {

	public static void main(String[] args) throws ClassNotFoundException, IOException {		
		
		
		ReadData data = new ReadData();
		data.readData();		

		NetworkGraph adj = data.getAdj();
		SocialCommunities community = new SocialCommunities();
		SingleSourceReachablity find = new SingleSourceReachablity();
		BST bst = adj.getBst();
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("			Analysing Network Data Using Graphs");
		
		System.out.println("\n\nNote! For analysing network data, we have choosen a small data set from UC San Diago 2005 facebook Data Set");
		System.out.println("If you wanna add more data, please change stack size according to your data set");
		
		boolean run = true;
		
		while (run) {
		
		
			System.out.println("\n[+] Choose from options below: ");
			
			System.out.println("\n1. Single Source Reachablity Problem\n2. Find Communities in Graph\n3. Analyse Data Using Default Settings\n4. Find Adjacents of a Vertex\n5. Exit");
			System.out.print("\nEnter your choice: \n$ ");
			
			int choice = in.nextInt();
			
			if (choice == 1) {
				
				System.out.print("Enter first vertex v: \n$ ");
				int vertexKey = in.nextInt();
				System.out.print("Enter second vertex u: \n$ ");
				int secondKey = in.nextInt();
				
				GraphNode v = bst.searchNode(bst.getRoot(), vertexKey);
				GraphNode u = bst.searchNode(bst.getRoot(), secondKey);
				
				if (v == null) {
					System.out.println("First key NOT found");
					continue;
				}
				if (u == null) {
					System.out.println("Second key NOT found");
					continue;
				}
				
				boolean search = find.BFS(adj, v.vertex, u.vertex);
				if (search)
					System.out.println("Vertex: " + u.vertex.getKey() + " is reachable from " + v.vertex.getKey());
				else
					System.out.println("Vertex: " + u.vertex.getKey() + " is not reachable from " + v.vertex.getKey());
				
			}
			else if (choice == 2) {
				community.stronglyConnectedComponents(adj);
				
				System.out.println("Communties in graph are: ");
				
				for (int i = 0; i <adj.getVertices(); i++) {
					GraphVertex u = adj.getAt(i).v;
					System.out.println("\nCommunity for vertex " + u.getKey() + " is: ");
					ArrayList<GraphVertex> components = u.getCommunity();
					
					for (GraphVertex v: components) {
						System.out.println(v.getKey());
					}
				}
			}
				
			else if (choice == 3) {
					
			
				System.out.println("\n\nAnalysing data...");
				System.out.println("\nTotal number of vertices are: " + adj.getVertices());
				System.out.println("\nTotal number of edges are: " + adj.getEdges());
					
				community.dfs(adj, false);
				
				System.out.println("\nNeighbours of vertex 0 are: ");
				for (GraphVertex v: adj.getFirstVertex().getNeighbours()) {
					System.out.println(v.getKey());
				}
				
				community.stronglyConnectedComponents(adj);
				
				System.out.println("Communties in graph are: ");
				
				for (int i = 0; i <adj.getVertices(); i++) {
					GraphVertex u = adj.getAt(i).v;
					System.out.println("\nCommunity for vertex " + u.getKey() + " is: ");
					ArrayList<GraphVertex> components = u.getCommunity();
					
					for (GraphVertex v: components) {
						System.out.println(v.getKey());
					}
				}
			}
			
			else if (choice == 4) {
				System.out.print("\n[+] Enter vertex key for which you want to find neighbourse: \n$ ");
				int key = in.nextInt();
					
				GraphNode v = bst.searchNode(bst.getRoot(), key);
				if (v == null) {
					System.out.println("\n[!] Key NOT found");
					continue;
				}
				
				System.out.println("\nVertex " + v.vertex.getKey() + " has neighbours or adjacencies: ");
				for (GraphVertex u: v.vertex.getNeighbours()) {
					System.out.println(u.getKey());
				}
			}
			
			else if (choice == 5) {
				System.out.println("Thanks for using our system");
				break;
			}
			
			else {
				System.out.println("Invalid option selected, Please try again");
				continue;
			}
		
			
		}		
		
		
		
		
		
		//NetworkGraph adj = data.getAdj();
		
		/*
		adj.addEdge(4, 5);
		adj.addEdge(4, 6);
		adj.addEdge(5, 9);
		adj.addEdge(1, 0);
		adj.addEdge(0, 1);
		*/
		 /*
		 System.out.println("BFS for graph is: ");
		 BFS bfs = new BFS();
		 bfs.BFS(adj, adj.getFirstVertex());
		 System.out.println("Computing path");
		 //bfs.printPath(adj, adj.getFirstVertex(), adj.getAt(3).v);
		 
		 
		 System.out.println("\n\nRunning DFS on graph: ");
		 DFS dfs = new DFS();
		 
		 dfs.dfs(adj,false);
		 
		 SocialCommunities community = new SocialCommunities();
		 community.stronglyConnectedComponents(adj);
		 */
	}

}

