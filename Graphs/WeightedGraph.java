package Graphs;


import java.util.*;

/**
 * @author BianWenKai
 * @DATE 2021/11/16 - 16:29
 **/
public class WeightedGraph {

    private class Node {
        private String label;
        private List<Edge> edges = new ArrayList<>();

        public Node(String label) {
            this.label = label;
        }

        public void addEdge(Node to, int weight) {
            edges.add(new Edge(this, to, weight));
        }

        @Override
        public String toString() {
            return label;
        }
    }

    private class Edge {
        private Node from;
        private Node to;
        private int weight;

        public Edge(Node from, Node to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return from + " -> " + to;
        }
    }

    private Map<String,Node> nodeMap = new HashMap<>();

    public void addNode(String label) {
        Node node = new Node(label);
        nodeMap.putIfAbsent(label, node);
    }

    public void addEdge(String from, String to, int weight) {
        Node fromNode = nodeMap.get(from);
        if (fromNode == null)
            throw new IllegalArgumentException("This is not a valid node");

        Node toNode = nodeMap.get(to);
        if (toNode == null)
            throw new IllegalArgumentException("This is not a valid node");

        fromNode.addEdge(toNode, weight);
        toNode.addEdge(fromNode, weight);

    }

    public void print() {
        for (Node node : nodeMap.values()) {
            if (node.edges.size() != 0)
                System.out.println(node + " is connected with " + Arrays.toString(node.edges.toArray()));
        }
    }
}
