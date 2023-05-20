package graphs;

import java.util.concurrent.LinkedBlockingQueue;

public class MyQueue implements Queue<Vertex> {
	
	private int vertices;
	private Vertex v[];
	private int start;
	private int end;
	private int size;
	
	
	public MyQueue(int vertices) {
		LinkedBlockingQueue<Vertex> q = new LinkedBlockingQueue<>();
		
		this.vertices = vertices;
		v = new GraphVertex[vertices];
		start = 0;
		end = 0;
		size = 0;
	}
	
	@Override
	public void enQueue(Vertex u) {
		System.out.println("enqueuing at index " + start);
		v[start++] = u;
		//start = start % this.vertices;
		this.size++;
	}

	@Override
	public Vertex deQueue() {
		this.size --;
		//int temp = end;
		//end ++;
		//end = end % this.vertices;
		return v[end++];
	}
	
	public boolean isEmpty() {
		if (size == 0)
			return true;
		else
			return false;
	}

	public int getSize() {
		return this.size;
	}
}
