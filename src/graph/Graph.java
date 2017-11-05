package graph;

import java.util.Iterator;



public interface Graph<N extends AbstractNode, E extends Edge<N>> {
	
	void addNode(N node);
	
	
	
	void addEdge(E edge);
	
	
	
	boolean removeEdge(E edge);
	
	
	
	boolean removeNode(N node);
	
	
	
	boolean contains(N node);
	
	
	
	boolean contains(E edge);
	
	
	
	Iterator<N> nodesIterator();
	
	
	
	Iterator<E> edgesIterator();
	
}
