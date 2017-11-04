package graph;

import java.util.Iterator;



public interface Graph<T> {
	
	public void addNode(Node<T> node);
	
	
	
	public void addEdge(Edge<T> edge);
	
	
	
	public boolean removeEdge(Edge<T> edge);
	
	
	
	public boolean removeNode(Node<T> node);
	
	
	
	public boolean contains(Node<T> node);
	
	
	
	public boolean contains(Edge<T> edge);
	
	
	
	public Iterator<Node<T>> nodesIterator();
	
	
	
	public Iterator<Edge<T>> edgesIterator();
	
}
