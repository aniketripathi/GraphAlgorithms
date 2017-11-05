package attributes;

import java.util.List;

import graph.AbstractNode;



public interface PathTracer<T> {
	
	AbstractNode getParent();
	
	
	
	void setParent(AbstractNode parent);
	
	
	
	int getDistance();
	
	
	
	void setDistance(int distance);
	
	
	
	boolean isDistanceInfinite();
	
	
	
	void setDistanceInfinite(boolean isInfinite);
	
	
	
	List<T> tracePath();
}
