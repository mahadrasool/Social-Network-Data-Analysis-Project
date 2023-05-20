package graphs;

public interface Graph<V> {

	public V addVertex(int val);
	public void addEdge(int from, int to);
}
