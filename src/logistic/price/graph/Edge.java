package logistic.price.graph;

public class Edge {

	private int hard;
	private Node origin;
	private Node target;

	public Edge(Node origin, Node target, int hard) {

		this.hard = hard;
		this.origin = origin;
		this.target = target;
	}

	public int getHard() {

		return hard;
	}

	public Node getTarget() {
		return target;
	}

	public Node getOrigin() {
		return origin;
	}

}
