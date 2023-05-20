package stack;
import java.util.ArrayList;

import graphs.GraphVertex;

public class StackOfVertices implements Stack<GraphVertex>{
	
	private ArrayList<GraphVertex> stack;
	private int top;
	private int size;
	
	public StackOfVertices() {
		this.stack = new ArrayList<GraphVertex>();
		this.top = -1;
		this.size = 0;
	}
	
	
	public void push(GraphVertex v) {
		this.top ++;
		this.size ++;
		stack.add(v);
	}
	
	
	public int size() {
		return this.size;
	}
	
	public GraphVertex pop() {
		GraphVertex u = this.stack.get(top);
		this.stack.remove(top);
		this.size --;
		this.top --;
		return u;
	}
		
}
