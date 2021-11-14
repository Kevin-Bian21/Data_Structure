package Graphs;

import java.util.*;

/**
 * @author BianWenKai
 * @DATE 2021/11/14 - 11:45
 *
 * Graph
 *      Node
 *          label:String
 *      addNode(label)
 *      removeNode(label)
 *      addEdge(from, to)
 *      removeEdge(from, to)
 *      print()
 *          A is connected with [B, C]
 *          B is connected with [A]
 */
public class Graph {

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

    private Map<String,Node> nodeMap = new HashMap<>();

    private Map<Node, List<Node>> adjacencyNodes = new HashMap<>();

    public void addNode(String label) {
        Node node = new Node(label);
        nodeMap.putIfAbsent(label, node);
        //在添加节点的时候创建存放节点的相邻节点的空的ArrayList;
        adjacencyNodes.putIfAbsent(node, new ArrayList<>());
    }

    //删除节点，需要将该节点删掉，并且其他节点中如果和该节点有关联，则需要从关联数组中移除该节点
    public void removeNode(String label) {
        Node node = nodeMap.get(label);
        if (node == null)
            throw new IllegalArgumentException();

        for (Node key : adjacencyNodes.keySet()) {
            adjacencyNodes.get(key).remove(node);
        }
        nodeMap.remove(label);
        adjacencyNodes.remove(node);
    }

    public void addEdge(String from, String to) {
        if (nodeMap.get(from) == null)
            throw new IllegalArgumentException("The from is not valid node");
        if (nodeMap.get(to) == null)
            throw new IllegalArgumentException("The to is not valid node");

        adjacencyNodes.get(nodeMap.get(from)).add(nodeMap.get(to));
    }

    public void romeEdge(String from, String to) {
        adjacencyNodes.get(nodeMap.get(from)).remove(nodeMap.get(to));
    }

    public void print() {
        for (Map.Entry<Node, List<Node>> map : adjacencyNodes.entrySet()) {
            if (map.getValue().size() != 0){
                System.out.println(map.getKey() + " is connected with " + Arrays.toString(map.getValue().toArray()));
            }
        }
    }
}
