package graphs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadData {

	
	/**
	 * Graphs are represented by adjacency lists, 
	 * Creating an adjacency list that will contain all edges read from data
	 */
	private NetworkGraph adj;
	
	public NetworkGraph getAdj() {
		return adj;
	}

	public ReadData() {
		this.adj = new NetworkGraph();
	}
	
	
	/**
	 * Using Scanner to read data, because ObjectInputStream is showing IO Error
	 * ObjectInputStream can only read data from file written from ObjectOutputStream
	 * Here, reading data by Scanner only, but ObjectInput and ObjectOutput Streams have been used in other classes
	 */
	public void readData() {
		
		File file = new File("facebook_1000.txt");
		Scanner read = null;
		try {
			read = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("Sorry, file cannot be read");
			return;
		}
		
		while (read.hasNext()) {
			int s = read.nextInt();
			int v = read.nextInt();
			
			adj.addEdge(s, v);
			//System.out.println("(" + s + ", " + v + ")");
		}
		
		read.close();
				
	}
	
	
}
