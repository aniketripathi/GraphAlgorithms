package graph;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;



public class UndirectedGraph<T> implements Graph<T> {
	
	private Set<Node<T>>		nodes;
	private Set<Edge<T>>		edges;
	private final static int	NODES_SET_CAPACITY	= 7;
	
	
	
	public UndirectedGraph(int numberOfVertices, int numberOfEdges) {
		nodes = new HashSet<Node<T>>(numberOfVertices);
		edges = new HashSet<Edge<T>>(numberOfEdges);
	}
	
	
	
	public UndirectedGraph() {
		this(NODES_SET_CAPACITY, NODES_SET_CAPACITY * NODES_SET_CAPACITY / 2);
	}
	
	
	
	@Override
	public void addNode(Node<T> node) {
		
		if (node == null)
			throw new IllegalArgumentException("Null node not allowed in graph");
		
		nodes.add(node);
	}
	
	
	
	@Override
	public void addEdge(Edge<T> edge) {
		
		if (edge == null)
			throw new IllegalArgumentException("Null edge is not allowed in graph");
		
		edges.add(edge);
		edge.getStartNode();
		addNode(edge.getStartNode());
		addNode(edge.getEndNode());
	}
	
	
	
	public void addConnectedNodes(Node<T> node1, Node<T> node2) {
		
		addEdge(new Edge<T>(node1, node2));
	}
	
	
	
	@Override
	public boolean removeNode(Node<T> node) {
		
		boolean successful = false;
		if (nodes.contains(node)) {
			Iterator<Edge<T>> iterator = edges.iterator();
			
			while (iterator.hasNext()) {
				Edge<T> edge = iterator.next();
				
				if (edge.isEndNode(node))
					removeEdge(edge);
			}
			successful = nodes.remove(node);
		}
		
		return successful;
	}
	
	
	
	@Override
	public boolean removeEdge(Edge<T> edge) {
		
		Node<T> startNode = edge.getStartNode();
		Node<T> endNode = edge.getEndNode();
		
		startNode.removeNeighbor(endNode);
		endNode.removeNeighbor(startNode);
		return edges.remove(edge);
	}
	
	
	
	@Override
	public boolean contains(Node<T> node) {
		
		return nodes.contains(node);
	}
	
	
	
	@Override
	public boolean contains(Edge<T> edge) {
		
		return edges.contains(edge);
	}
	
	
	
	@Override
	public Iterator<Node<T>> nodesIterator() {
		
		return nodes.iterator();
	}
	
	
	
	@Override
	public Iterator<Edge<T>> edgesIterator() {
		
		return edges.iterator();
	}
	
	
	
	public Edge<T> getEdge(Node<T> node1, Node<T> node2) {
		
		Edge<T> edge = null;
		
		if (contains(node1) && contains(node2))
			for (Edge<T> tempEdge : edges)
			if (tempEdge.isConnectedBy(node1, node2))
				edge = tempEdge;
		return edge;
	}
	
}
