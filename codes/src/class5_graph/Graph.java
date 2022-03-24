package class5_graph;

import java.util.HashMap;
import java.util.HashSet;

public class Graph {
	public HashMap<Integer, Node> nodes;  //key + 点集
	public HashSet<Edge> edges; //所有边
	
	public Graph() {
		nodes = new HashMap<>();
		edges = new HashSet<>();
	}
}
