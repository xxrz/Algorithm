package class5_graph;

public class Edge {
	public int weight;  //权值
	public Node from; //从哪个点出来的
	public Node to;

	public Edge(int weight, Node from, Node to) {
		this.weight = weight;
		this.from = from;
		this.to = to;
	}

}
