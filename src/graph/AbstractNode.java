package graph;

import java.util.Iterator;

import attributes.Data;



public abstract class AbstractNode {
	
	protected Data data;
	
	
	
	public AbstractNode(Data data) {
		this.data = data;
	}
	
	
	
	public abstract <N extends AbstractNode> Iterator<N> neighborIterator();
	
	
	
	public abstract boolean isNeighbor(AbstractNode abstractNode);
	
	
	
	protected abstract void addNeighbor(AbstractNode abstractNode);
	
	
	
	protected abstract boolean removeNeighbor(AbstractNode abstractNode);
	
	
	
	public Data getData() {
		
		return data;
	}
	
	
	
	@Override
	public String toString() {
		
		return data.toString();
	}
}
