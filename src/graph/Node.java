package graph;

import java.util.Iterator;



public abstract class Node<T> {
	
	protected T attributes;
	
	
	
	public Node(T attributes) {
		this.attributes = attributes;
	}
	
	
	
	public abstract Iterator<Node<T>> getNeighbors();
	
	
	
	public abstract boolean isNeighbor(Node<T> node);
	
	
	
	protected abstract void addNeighbor(Node<T> node) throws NullPointerException;
	
	
	
	protected abstract boolean removeNeighbor(Node<T> node);
	
	
	
	public T getAttributes() {
		
		return attributes;
	}
	
}
