package mit;

import java.util.ArrayList;

public class DFS {
	
	ArrayList<Integer> parent;
	ArrayList<Integer> order;
	int start;
	
	public DFS() {
		parent = new ArrayList<Integer>();
		order = new ArrayList<Integer>();	
		start = 0;
	}
	
	public void dfs(Adjacency adj[]) {
		
		for (int i = 0; i < adj.length; i++) {
			int size = adj[i].getArrayList().size();
			ArrayList<Integer> list = adj[i].getArrayList();
			for (int k = 0; k < size; k++) {
				if (!isVisited(list.get(k))) {
					order.add(list.get(k));
					System.out.println("Value visited is: " + list.get(k));
				}
			}
		}
	}
	
	public boolean isVisited(int value) {
		boolean check = false;
		for (int key:order) {
			if (key == value)
				check = true;
		}
		return check;
		
	}

}
