package graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class Vertex<T> extends Node<T> {
	
	private final List<Node<T>>	neighbors;
	private final static int	NEIGHBOR_NODES	= 7;
	
	
	
	public Vertex(T attributes) {
		super(attributes);
		neighbors = new ArrayList<Node<T>>(NEIGHBOR_NODES);
	}
	
	
	
	public T getData() {
		
		return attributes;
	}
	
	
	
	@Override
	public Iterator<Node<T>> getNeighbors() {
		
		return neighbors.iterator();
	}
	
	
	
	@Override
	public boolean isNeighbor(Node<T> node) {
		
		return neighbors.contains(node);
	}
	
	
	
	@Override
	protected void addNeighbor(Node<T> node) {
		
		if (node == null)
			throw new IllegalArgumentException("Null neighbor not allowed as neighbor");
		
		neighbors.add(node);
	}
	
	
	
	@Override
	protected boolean removeNeighbor(Node<T> node) {
		
		return neighbors.remove(node);
	}
	
}
