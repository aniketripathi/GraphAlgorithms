package graph;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;



public class UndirectedGraph<N extends AbstractNode, E extends Edge<N>> implements Graph<N, E> {
	
	private Set<N>				nodes;
	private Set<E>				edges;
	private final static int	NODES_SET_CAPACITY	= 7;
	
	
	
	public UndirectedGraph(int numberOfVertices, int numberOfEdges) {
		nodes = new HashSet<>(numberOfVertices);
		edges = new HashSet<>(numberOfEdges);
	}
	
	
	
	public UndirectedGraph() {
		this(NODES_SET_CAPACITY, NODES_SET_CAPACITY * NODES_SET_CAPACITY / 2);
	}
	
	
	
	@Override
	public void addNode(N node) {
		
		if (node == null)
			throw new IllegalArgumentException("Null node not allowed in graph");
		
		nodes.add(node);
	}
	
	
	
	@Override
	public void addEdge(E edge) {
		
		if (edge == null)
			throw new IllegalArgumentException("Null edge is not allowed in graph");
		
		edges.add(edge);
		edge.getStartNode();
		addNode(edge.getStartNode());
		addNode(edge.getEndNode());
	}
	
	
	
	@Override
	public boolean removeNode(N node) {
		
		boolean successful = false;
		if (nodes.contains(node)) {
			Iterator<E> iterator = edges.iterator();
			
			while (iterator.hasNext()) {
				E edge = iterator.next();
				
				if (edge.isEndNode(node))
					removeEdge(edge);
			}
			successful = nodes.remove(node);
		}
		
		return successful;
	}
	
	
	
	@Override
	public boolean removeEdge(E edge) {
		
		AbstractNode startNode = edge.getStartNode();
		AbstractNode endNode = edge.getEndNode();
		
		startNode.removeNeighbor(endNode);
		endNode.removeNeighbor(startNode);
		return edges.remove(edge);
	}
	
	
	
	@Override
	public boolean contains(N node) {
		
		return nodes.contains(node);
	}
	
	
	
	@Override
	public boolean contains(E edge) {
		
		return edges.contains(edge);
	}
	
	
	
	@Override
	public Iterator<N> nodesIterator() {
		
		return nodes.iterator();
	}
	
	
	
	@Override
	public Iterator<E> edgesIterator() {
		
		return edges.iterator();
	}
	
	
	
	public E getEdge(N node1, N node2) {
		
		E edge = null;
		
		if (contains(node1) && contains(node2))
			for (E tempEdge : edges)
			if (tempEdge.isConnectedBy(node1, node2))
				edge = tempEdge;
		return edge;
	}
	
}
