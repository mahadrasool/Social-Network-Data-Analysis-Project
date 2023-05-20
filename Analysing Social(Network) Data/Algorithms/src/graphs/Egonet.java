package graphs;

public interface Egonet<T> {
	
	public NetworkGraph getEgonet(NetworkGraph adj, T center);

}
