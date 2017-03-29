package logistic.price.graph;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import logistic.price.graph.Graph;
import logistic.price.graph.Node;
import logistic.price.utils.FileHandle;

public class GraphTest {

	@SuppressWarnings("resource")
	@Test
	public void testShortPath() {
		File file = new File("/tmp/test/01.csv");
		String originName = "ME";
		String targetName;
		Node origin = new Node();
		Node target = new Node();
		List<Node> shortPath = new ArrayList<Node>();

		// Set up for the graph
		Graph graph = new Graph();
		graph = FileHandle.generateGraph(file);

		String line;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));

			while ((line = reader.readLine()) != null) {
				if (line.contains("@")) {
					targetName = line.split(",")[1];
					origin = graph.getNodeByName(originName);
					target = graph.getNodeByName(targetName);
					shortPath = graph.findShortPath(origin, target);
					assertEquals(shortPath.get(0).getDistance(), 17);
					assertEquals(shortPath.get(0).getDistance(), 17);
					assertEquals(shortPath.get(0).getDistance(), 17);
					break;
				}
			}
		} catch (IOException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
