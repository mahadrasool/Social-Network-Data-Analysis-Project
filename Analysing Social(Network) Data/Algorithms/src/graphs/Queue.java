package graphs;

public interface Queue<T> {
	
	public void enQueue(T key);
	public T deQueue();
	public boolean isEmpty();

}
