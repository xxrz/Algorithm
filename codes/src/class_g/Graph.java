package class_g;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class Node {
    public int val;
    public int in;
    public int out;
    public ArrayList<Node> nexts;
    public ArrayList<Node> edges;

    public Node(int val){ //参数只有val
        this.val = val;
        this.in = 0;
        this.out = 0;
        this.nexts = new ArrayList<>();
        this.edges = new ArrayList<>();
    }
}

class Edge {
    public int weight;
    public Node from;
    public Node to;

    public Edge(int weight, Node from, Node to){
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}


public class Graph{
    public HashMap<Integer,Node> nodes;
    public HashSet<Edge> edges;

    public Graph(){ //没有参数
        this.nodes = new HashMap<>();
        this.edges = new HashSet<>();
    }
}

class GraphGenerator {
    //此处输入的是 邻接表不是邻接矩阵
    public Graph createGraph(Integer[][] matrix){
        Graph graph = new Graph();

        for (int i = 0; i < matrix.length; i++) {
            //添加边的信息
            Integer weight = matrix[i][0];
            Integer from  = matrix[i][1];
        }
    }


}