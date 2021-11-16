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

    public int getShortestDistance(String from, String to) {

        //不能在此在new该from节点对象，否则nodeMap中存放的fromNode对象和NodeEntry中的node对象虽然label一样，但却是两个不同的对象
        //这就会导致使用该fromNode节点拿不到nodeMap中label对应节点的edges。所以node节点需要从nodeMap中获取
//        Node fromNode = new Node(from);

        //用来存放当前的节点到其余节点的距离
        Map<Node,Integer> distances = new HashMap<>();
        for (Node node : nodeMap.values())
            distances.put(node, Integer.MAX_VALUE);

        //自己到自己的距离为 0，因此更新distances
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
        //自己到自己的距离为 0，因此更新distances
        distances.replace(fromNode, 0);

        //用来存放该Node和与它相邻的前一个节点对象
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


}
