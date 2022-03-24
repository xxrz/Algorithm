package class5_graph;

import java.util.ArrayList;

// 点结构的描述
public class Node {
	public int value;  //数据项
	public int in; //入度（数量）
	public int out; //出度
	public ArrayList<Node> nexts; //从当前点出发的邻接点
	public ArrayList<Edge> edges; //所有边

	public Node(int value) {
		this.value = value;
		in = 0;
		out = 0;
		nexts = new ArrayList<>();
		edges = new ArrayList<>();
	}
}
