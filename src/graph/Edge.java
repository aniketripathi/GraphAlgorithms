package graph;

public class Edge<N extends AbstractNode> {
	
	private final N	startNode;
	private final N	endNode;
	
	
	
	public Edge(N startNode, N endNode) throws IllegalArgumentException {
		if (startNode == null)
			throw new IllegalArgumentException("startNode cannot be null");
		
		if (endNode == null)
			throw new IllegalArgumentException("endNode cannot be null");
		
		this.startNode = startNode;
		this.endNode = endNode;
		startNode.addNeighbor(endNode);
		endNode.addNeighbor(startNode);
	}
	
	
	
	public boolean isEndNode(N node) {
		
		return (node == startNode || node == endNode);
	}
	
	
	
	public boolean isConnectedBy(N node1, N node2) {
		
		return (node1 == startNode && node2 == endNode ||
				node1 == endNode && node1 == startNode);
	}
	
	
	
	public N getOtherNode(N node) {
		
		return (startNode == node ? endNode : startNode);
	}
	
	
	
	public N getStartNode() {
		
		return startNode;
	}
	
	
	
	public N getEndNode() {
		
		return endNode;
		
	}
}
