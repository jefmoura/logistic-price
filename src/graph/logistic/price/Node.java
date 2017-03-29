package graph.logistic.price;

public class Node {

	private String name;
	private int distance = Integer.MAX_VALUE;
	private boolean visited = false;
	private Node previous;

	public Node() {
	}

	public Node(String name) {
		this.name = name;
	}

	public String getName() {

		return name;
	}
	
	public void unVisited() {

		visited = false;
	}

	public void setVisited() {

		visited = true;
	}

	public boolean wasVisited() {

		return visited;
	}

	public void setDistance(int distance) {

		this.distance = distance;
	}

	public int getDistance() {

		return distance;
	}

	public void setPrevious(Node previous) {

		this.previous = previous;
	}

	public Node getPrevious() {

		return previous;
	}

	public int compareTo(Node node) {

		if (this.getDistance() < node.getDistance())
			return -1;
		else if (this.getDistance() == node.getDistance())
			return 0;

		return 1;
	}

	@Override
	public boolean equals(Object object) {
		boolean isEqual = false;

		if (object != null && object instanceof Node) {
			isEqual = (this.name == ((Node) object).name);
		}
		return isEqual;
	}
}
