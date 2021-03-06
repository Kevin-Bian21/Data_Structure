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

        public List<Edge> getEdges() {
            return edges;
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

    private class NodeEntry {
        private Node node;
        private int priority;

        private NodeEntry(Node node, int priority) {
            this.node = node;
            this.priority = priority;
        }

        public Node getNode() {
            return node;
        }
    }

    /**
     * Dijkstra's Algorithm
     *
     * @param from begin node
     * @param to   end node
     * @return the shortestDistance
     */
    public int getShortestDistance(String from, String to) {
        if (nodeMap.isEmpty())
            throw new IllegalStateException();

        //???????????????????????????????????????????????????
        Map<Node,Integer> distances = new HashMap<>();
        for (Node node : nodeMap.values())
            distances.put(node, Integer.MAX_VALUE);

        //??????????????????????????? 0???????????????distances
        distances.replace(nodeMap.get(from), 0);

        Set<Node> visited = new HashSet<>();

        PriorityQueue<NodeEntry> queue = new PriorityQueue<>(
                Comparator.comparingInt(nodeEntry -> nodeEntry.priority)
        );
        queue.add(new NodeEntry(nodeMap.get(from), 0));

        while (!queue.isEmpty()) {
            Node current = queue.remove().node;
            visited.add(current);

            for (Edge edge : current.getEdges()) {
                if (visited.contains(edge.to))
                    continue;

                int newDistance = distances.get(current) + edge.weight;

                if (newDistance < distances.get(edge.to)) {
                    distances.replace(edge.to, newDistance);
                    queue.add(new NodeEntry(edge.to, newDistance));
                }
            }
        }
        return distances.get(nodeMap.get(to));
    }

    public Path getShortestPath(String from, String to) {
        Node fromNode = nodeMap.get(from);
        Node toNode = nodeMap.get(to);

        Map<Node,Integer> distances = new HashMap<>();
        for (Node node : nodeMap.values())
            distances.put(node, Integer.MAX_VALUE);
        //??????????????????????????? 0???????????????distances
        distances.replace(fromNode, 0);

        //???????????????Node???????????????????????????????????????
        Map<Node,Node> previousNodes = new HashMap<>();

        Set<Node> visited = new HashSet<>();


        PriorityQueue<NodeEntry> queue = new PriorityQueue<>(
                Comparator.comparingInt(nodeEntry -> nodeEntry.priority)
        );
        queue.add(new NodeEntry(fromNode, 0));

        while (!queue.isEmpty()) {
            Node current = queue.remove().node;
            visited.add(current);

            for (Edge edge : current.getEdges()) {
                if (visited.contains(edge.to))
                    continue;

                int newDistance = distances.get(current) + edge.weight;

                if (newDistance < distances.get(edge.to)) {
                    distances.replace(edge.to, newDistance);
                    previousNodes.put(edge.to, current);
                    queue.add(new NodeEntry(edge.to, newDistance));
                }
            }
        }
        Stack<Node> stack = new Stack<>();
        stack.push(toNode);
        Node previous = previousNodes.get(toNode);
        while (previous != null) {
            stack.push(previous);
            previous = previousNodes.get(previous);
        }

        Path path = new Path();
        while (!stack.isEmpty())
            path.add(stack.pop().label);

        return path;
    }

    //???????????????????????????
    public boolean hasCycle() {
        //????????????????????????
        Set<Node> visited = new HashSet<>();
        for (Node node : nodeMap.values()) {
            if (!visited.contains(node))
                if (hasCycle(node, null, visited))
                    return true;
        }
        return false;
    }

    private boolean hasCycle(Node node, Node parent, Set<Node> visited) {

        visited.add(node);

        for (Edge edge : node.getEdges()) {
            if (edge.to.equals(parent))
                continue;
            if (visited.contains(edge.to))
                return true;
            if (hasCycle(edge.to, node, visited))
                return true;
        }
        return false;
    }

    /**
     * Prim's Algorithm
     * ???????????????????????????????????????????????????????????????????????????
     *
     * 1. ??????????????????
     * 2. ??????????????????????????? tree ????????????????????????
     */
    public WeightedGraph getMinimumSpanningTree(){
        WeightedGraph tree = new WeightedGraph();

        if (nodeMap.isEmpty())
            return tree;

        PriorityQueue<Edge> edges = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));

        Node startNode = nodeMap.values().iterator().next();

        edges.addAll(startNode.getEdges());
        tree.addNode(startNode.label);

        if (edges.isEmpty())
            return tree;
        //???nodeMap???????????????????????????tree???
        while (tree.nodeMap.size() < nodeMap.size()) {
            //???PriorityQueue?????????edge?????????????????????????????????edge?????????weight?????????
            Edge minEdge = edges.remove();
            Node nextNode = minEdge.to;

            if (tree.nodeMap.containsKey(nextNode.label))
                continue;

            tree.addNode(nextNode.label);
            tree.addEdge(minEdge.from.label, minEdge.to.label, minEdge.weight);

            for (Edge edge : nextNode.getEdges())
                if (!tree.nodeMap.containsKey(edge.to.label))
                    edges.add(edge);
        }
        return tree;
    }
}
