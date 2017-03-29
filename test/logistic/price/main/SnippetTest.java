package logistic.price.main;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import logistic.price.graph.Graph;
import logistic.price.graph.Node;
import logistic.price.product.Package;
import logistic.price.product.Shipping;
import logistic.price.utils.FileHandle;

public class SnippetTest {

	@SuppressWarnings("resource")
	@Test
	public void testCases() {
		File folder = new File("/tmp/test");
		File[] listOfFiles = folder.listFiles();
		String originName = "ME";
		String targetName;

		// Set up for package and shipping
		ArrayList<String[]> packageInfo = new ArrayList<String[]>();
		String line;
		Package pack;
		Shipping shipping;
		double width;
		double length;
		double height;
		double weight;
		double cost;

		for (File file : listOfFiles) {
			// Set up for the graph
			Graph graph = FileHandle.generateGraph(file);

			try {
				BufferedReader reader = new BufferedReader(new FileReader(file));

				while ((line = reader.readLine()) != null) {
					if (line.contains("@")) {
						// Processing the string
						targetName = line.split(",")[1];
						if (line.split(",")[3].equals("~")) {
							cost = -1;
						} else {
							cost = Double.parseDouble(line.split(",")[3]);
						}
						packageInfo.add(line.split(",")[2].split("x"));

						// Getting package information
						width = Double.parseDouble(packageInfo.get(0)[0]);
						length = Double.parseDouble(packageInfo.get(0)[1]);
						height = Double.parseDouble(packageInfo.get(0)[2]);
						weight = Double.parseDouble(packageInfo.get(0)[3]);

						pack = new Package(width, length, height, weight);
						shipping = new Shipping(pack, originName, targetName);
						shipping.setCost(shipping.calculateCost(graph));

						// Check if the found cost is the expected one
						assertEquals(cost, shipping.getCost(), 0.01);

						// Clear graph for the next iteration
						for (Node node : graph.getNodes()) {
							node.setDistance(Integer.MAX_VALUE);
							node.setPrevious(null);
							node.unVisited();
						}
						packageInfo.clear();
					}
				}
			} catch (IOException e) { // TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
