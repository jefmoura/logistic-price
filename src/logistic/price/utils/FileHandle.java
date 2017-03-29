package logistic.price.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import logistic.price.graph.Edge;
import logistic.price.graph.Graph;
import logistic.price.graph.Node;

public class FileHandle {
	
	@SuppressWarnings("resource")
	public static Graph generateGraph(File file) {
		Graph graph = new Graph();
		Node nodeSource = new Node();
		Node neighbor = new Node();
		Edge edge;
		String line;
		String hard;
		ArrayList<String[]> nodeInfo = new ArrayList<String[]>();
		Map<String, Node> nodeMap = new HashMap<String, Node>();

		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			while ((line = reader.readLine()) != null) {
				reader.mark(0);
				for (String info : line.split(",")) {
					if (info.contains("@")) {
						reader.reset();
						return graph;
					}
					nodeInfo.add(info.split(":"));
					if (nodeInfo.get(0).length == 1) {
						nodeSource = nodeMap.get(nodeInfo.get(0)[0]);
						if (nodeSource == null) {
							nodeSource = new Node(nodeInfo.get(0)[0]);
							graph.addNode(nodeSource);
							nodeMap.put(nodeSource.getName(), nodeSource);
						}
					} else if (nodeInfo.get(0).length > 1) {
						neighbor = nodeMap.get(nodeInfo.get(0)[0]);
						if (neighbor == null) {
							neighbor = new Node(nodeInfo.get(0)[0]);
							graph.addNode(neighbor);
							nodeMap.put(neighbor.getName(), neighbor);
						}
						hard = nodeInfo.get(0)[1];
						edge = new Edge(nodeSource, neighbor, Integer.parseInt(hard));
						graph.addEdge(edge);
					}
					nodeInfo.clear();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return graph;
	}

}
