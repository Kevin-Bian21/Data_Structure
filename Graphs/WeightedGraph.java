package Graphs;


import java.util.*;

/**
 * @author BianWenKai
 * @DATE 2021/11/16 - 16:29
 **/
public class WeightedGraph {

    private class Node {
        private String label;

        public Node(String label) {
            this.label = label;
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
    private Map<Node, List<Edge>> adjacencyList = new HashMap<>();

    public void addNode(String label) {
        Node node = new Node(label);
        nodeMap.put(label, node);
        adjacencyList.put(node, new ArrayList<>());
    }

    public void addEdge(String from, String to, int weight) {
        Node fromNode = nodeMap.get(from);
        if (fromNode == null)
            throw new IllegalArgumentException("This is not a valid node");

        Node toNode = nodeMap.get(to);
        if (toNode == null)
            throw new IllegalArgumentException("This is not a valid node");

        adjacencyList.get(fromNode).add(new Edge(fromNode, toNode, weight));
        adjacencyList.get(toNode).add(new Edge(toNode, fromNode, weight));

    }

    public void print() {
        for (Map.Entry<Node, List<Edge>> map : adjacencyList.entrySet()) {
            if (map.getValue().size() != 0){
                System.out.println(map.getKey() + " is connected with " + Arrays.toString(map.getValue().toArray()));
            }
        }
    }
}
