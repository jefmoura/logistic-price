package logistic.price.product;

import java.util.ArrayList;
import java.util.List;

import logistic.price.graph.Graph;
import logistic.price.graph.Node;

public class Shipping {

	private double cost;
	private Package pack;
	private String originName;
	private String targetName;

	public Shipping() {
	}

	public Shipping(Package pack, String originName, String targetName) {

		this.pack = pack;
		this.originName = originName;
		this.targetName = targetName;
	}

	public void setCost(double cost) {

		this.cost = cost;
	}

	public double getCost() {

		return cost;
	}

	public String getOriginName() {

		return originName;
	}

	public String getTargetName() {

		return targetName;
	}

	// The formula for computing the shipment
	public double calculateCost(Graph graph) {

		double cost;
		int weight;
		Node origin = new Node();
		Node target = new Node();
		List<Node> shortPath = new ArrayList<Node>();

		origin = graph.getNodeByName(this.originName);
		target = graph.getNodeByName(this.targetName);

		if (origin != null && target != null) {
			shortPath = graph.findShortPath(origin, target);
		} else {
			return 0;
		}
		if (shortPath.isEmpty()){
			return -1;
		}
		else {
			weight = shortPath.get(0).getDistance();
			cost = Math.sqrt(weight) * pack.getNormalizedWeight();
			return cost;
		}
	}

}
