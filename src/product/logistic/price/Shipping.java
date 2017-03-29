package product.logistic.price;

import java.util.ArrayList;
import java.util.List;

import graph.logistic.price.Graph;
import graph.logistic.price.Node;

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
		int hard;
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
			hard = shortPath.get(0).getDistance();
			cost = Math.sqrt(hard) * pack.getNormalizedWeight();
			return cost;
		}
	}

}
