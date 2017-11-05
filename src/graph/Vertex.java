package graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import attributes.Data;



public class Vertex extends AbstractNode {
	
	private final List<AbstractNode> neighbors;
	
	
	
	public Vertex(Data attributes) {
		super(attributes);
		neighbors = new LinkedList<AbstractNode>();
	}
	
	
	
	@Override
	public Data getData() {
		
		return data;
	}
	
	
	
	@Override
	public Iterator<AbstractNode> neighborIterator() {
		
		return neighbors.iterator();
	}
	
	
	
	@Override
	public boolean isNeighbor(AbstractNode abstractNode) {
		
		return neighbors.contains(abstractNode);
	}
	
	
	
	@Override
	protected void addNeighbor(AbstractNode abstractNode) {
		
		if (abstractNode == null)
			throw new IllegalArgumentException("Null neighbor not allowed as neighbor");
		
		neighbors.add(abstractNode);
	}
	
	
	
	@Override
	protected boolean removeNeighbor(AbstractNode abstractNode) {
		
		return neighbors.remove(abstractNode);
	}
	
}
