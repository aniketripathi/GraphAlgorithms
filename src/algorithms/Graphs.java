package algorithms;

import java.util.Iterator;
import java.util.LinkedList;

import attributes.Colorable;
import attributes.Colorable.Color;
import attributes.PathTracer;
import attributes.TimeStamp;
import graph.AbstractNode;
import graph.Edge;
import graph.Graph;



public final class Graphs {
	
	private Graphs() {
	}
	
	
	
	public static <N extends AbstractNode & Colorable & PathTracer<N>, E extends Edge<N>> void breadthFirstSearch(Graph<N, E> graph, N source) {
		
		/** Initialize All vertices **/
		for (Iterator<N> iterator = graph.nodesIterator(); iterator.hasNext();) {
			N node = iterator.next();
			node.setColor(Colorable.Color.WHITE);
			node.setDistanceInfinite(true);
			node.setParent(null);
		}
		/** initialize the source vertex **/
		source.setColor(Colorable.Color.NONE);
		source.setDistance(0);
		source.setParent(null);
		
		/** create a queue **/
		LinkedList<N> queue = new LinkedList<N>();
		queue.add(source);
		
		/** Apply Search for white(not yet discovered) nodes and enqueue them **/
		while (!queue.isEmpty()) {
			N node = queue.remove();
			for (Iterator<N> iterator = node.neighborIterator(); iterator.hasNext();) {
				N neighborNode = iterator.next(); 
				if (neighborNode.getColor() == Colorable.Color.WHITE) {
					neighborNode.setDistanceInfinite(false);
					neighborNode.setDistance(node.getDistance() + 1);
					neighborNode.setParent(node);
					queue.add(neighborNode);
				}
				node.setColor(Colorable.Color.NONE);
			}
		}
	}
	
	
	private static <N extends AbstractNode & Colorable & PathTracer<N> & TimeStamp, E extends Edge<N>> void depthFirstSearchVisit(N source, long time){
		time++;
		source.setStartingTime(time);
		source.setColor(Color.NONE);
		
		/** Traverse the neighbors of this node **/
		for(Iterator<N> iterator = source.neighborIterator(); iterator.hasNext(); ){
			N neighborNode = iterator.next();
			if(neighborNode.getColor() == Color.WHITE){
				neighborNode.setParent(source);
				depthFirstSearchVisit(neighborNode, time);		// traverse this neighbor first using same procedure
			}
		}
		
		source.setColor(Color.NONE);
		time++;
		source.setFinishingTime(time);
		
	}
	
	
	public static <N extends AbstractNode & Colorable & PathTracer<N> & TimeStamp, E extends Edge<N>> void depthFirstSearch(Graph<N,E> graph){
		
		/** Initialize all nodes **/	
		for(Iterator<N> iterator = graph.nodesIterator(); iterator.hasNext(); ){
			N node = iterator.next();
			node.setColor(Color.WHITE);
			node.setParent(null);
		}
		/** Traverse all nodes **/
		for(Iterator<N> iterator = graph.nodesIterator(); iterator.hasNext(); ){
			N node = iterator.next();
			
			if(node.getColor() == Color.WHITE)
				depthFirstSearchVisit(node, 0L); 		// traverse this node
		}
	}
	
	
}
