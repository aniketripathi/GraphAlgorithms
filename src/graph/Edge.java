package graph;

public class Edge<T> {
	
	private final Node<T>	startNode;
	private final Node<T>	endNode;
	
	
	
	public Edge(Node<T> startNode, Node<T> endNode) throws IllegalArgumentException {
		if (startNode == null)
			throw new IllegalArgumentException("startNode cannot be null");
		
		if (endNode == null)
			throw new IllegalArgumentException("endNode cannot be null");
		
		this.startNode = startNode;
		this.endNode = endNode;
		startNode.addNeighbor(endNode);
		endNode.addNeighbor(startNode);
	}
	
	
	
	public boolean isEndNode(Node<T> node) {
		
		return (node == startNode || node == endNode);
	}
	
	
	
	public boolean isConnectedBy(Node<T> node1, Node<T> node2) {
		
		return ( (node1 == startNode && node2 == endNode) ||
				 (node1 == endNode	 && node1 == startNode));
	}
	
	
	
	public Node<T> getOtherNode(Node<T> node) {
		
		return (startNode == node) ? endNode : startNode;
	}
	
	
	
	public Node<T> getStartNode() {
		
		return startNode;
	}
	
	
	
	public Node<T> getEndNode() {
		
		return endNode;
		
	}
}
