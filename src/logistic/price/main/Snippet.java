package logistic.price.main;

import java.io.File;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import logistic.price.graph.Graph;
import logistic.price.product.Package;
import logistic.price.product.Shipping;
import logistic.price.utils.FileHandle;

public class Snippet {

	public static void main(String args[]) {

		ArrayList<String[]> packageInfo = new ArrayList<String[]>();
		NumberFormat formatter = new DecimalFormat("0.00");
		File file = new File(args[0]);
		String originName = args[1];
		String targetName = args[2];

		Graph graph = new Graph();
		Shipping shipping;
		Package pack;

		double width;
		double length;
		double height;
		double weight;
		
		graph = FileHandle.generateGraph(file);
		packageInfo.add(args[3].split("x"));
		width = Double.parseDouble(packageInfo.get(0)[0]);
		length = Double.parseDouble(packageInfo.get(0)[1]);
		height = Double.parseDouble(packageInfo.get(0)[2]);
		weight = Double.parseDouble(packageInfo.get(0)[3]);

		pack = new Package(width, length, height, weight);
		shipping = new Shipping(pack, originName, targetName);

		shipping.setCost(shipping.calculateCost(graph));

		System.out.println("This is the lowest shipping cost from " + args[1] + " to " + args[2] + ":"
				+ formatter.format(shipping.getCost()) + " EUR");
	}

}
