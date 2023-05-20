package mit;

import java.util.ArrayList;

public class BFS {
	ArrayList<Integer> visited;
	ArrayList<Integer> finished;
	
	public BFS() {
		visited = new ArrayList<Integer>();
		finished = new ArrayList<Integer>();
	}
	
	public void BFS(Adjacency adj[],int vertices[]) {
		
		int size = vertices.length;
		
		for (int i = 0; i < size;i++) {
			ArrayList<Integer> list = adj[i].getArrayList();
			int val = list.get(0);
			if (!isVisited(val))
				visited.add(vertices[i]);	
		}
		
		//String c = "123";
	}
	
	public boolean isVisited(int key) {
		boolean check = false;
		for (int e: visited) {
			if (e == key)
				check = true;
		}
		
		return check;
	}

}
