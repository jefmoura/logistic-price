package logistic.price.graph;

public class Edge {

	private int weight;
	private Node origin;
	private Node target;

	public Edge(Node origin, Node target, int weight) {

		this.weight = weight;
		this.origin = origin;
		this.target = target;
	}

	public int getWeight() {

		return weight;
	}

	public Node getTarget() {
		return target;
	}

	public Node getOrigin() {
		return origin;
	}

}
