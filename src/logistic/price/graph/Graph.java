package logistic.price.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Graph {

	private List<Node> nodes = new ArrayList<Node>();
	private List<Edge> edges = new ArrayList<Edge>();

	public void setNodes(List<Node> nodes) {

		this.nodes.addAll(nodes);
	}

	public void setEdges(List<Edge> edges) {

		this.edges.addAll(edges);
	}

	public void addNode(Node newNode) {

		nodes.add(newNode);
	}

	public void addEdge(Edge newEdge) {

		edges.add(newEdge);
	}

	public List<Node> getNodes() {

		return nodes;
	}

	public List<Edge> getEdges() {

		return edges;
	}

	public Node getNodeByName(String name) {

		for (Node node : this.nodes) {
			if (name.equalsIgnoreCase(node.getName())) {
				return node;
			}
		}
		return null;
	}

	public List<Edge> getEdgesByNode(Node node) {

		List<Edge> edges = new ArrayList<Edge>();

		for (Edge edge : this.edges) {
			if (edge.getOrigin().equals(node)) {
				edges.add(edge);
			}
		}
		return edges;
	}

	// Algorithm of Dijkstra to find the shortest path between two nodes
	public List<Node> findShortPath(Node origin, Node target) {

		List<Node> shortPath = new ArrayList<Node>();
		List<Node> nextVisit = new ArrayList<Node>();
		List<Edge> currentEdges = new ArrayList<Edge>();
		Node currentNode = new Node();
		Node neighbor = new Node();
		Node nodePath = new Node();

		origin.setDistance(0);
		nextVisit.add(origin);

		// The algorithm
		while (!nextVisit.isEmpty()) {
			currentNode = nextVisit.get(0);
			currentEdges = this.getEdgesByNode(currentNode);

			for (Edge edge : currentEdges) {
				neighbor = edge.getTarget();

				if (!neighbor.wasVisited()) {
					int currentNodeDistance = currentNode.getDistance() + edge.getHard();
					if (neighbor.getDistance() > currentNodeDistance) {
						neighbor.setDistance(currentNodeDistance);
						neighbor.setPrevious(currentNode);

						/*
						 * If the neighbor is the wanted node and the
						 * currentNode distance is shorter than the previous
						 * found one, we set set short path to the currentNode.
						 */
						if (neighbor == target) {
							shortPath.clear();
							nodePath = neighbor;
							shortPath.add(neighbor);

							while (nodePath.getPrevious() != null) {
								shortPath.add(nodePath.getPrevious());
								nodePath = nodePath.getPrevious();
							}
						} else {
							if (!nextVisit.contains(neighbor)) {
								nextVisit.add(neighbor);
							}
						}
					}
				}
			}

			currentNode.setVisited();
			nextVisit.remove(currentNode);

			// We sort to get the slighter distance
			// TODO: Implement a Comparator for the Node class is better
			Collections.sort(nextVisit, new Comparator<Node>() {
				@Override
				public int compare(Node n1, Node n2) {
					return n1.compareTo(n2);
				}
			});
		}

		return shortPath;
	}

}
