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
 *      traversal()
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

    public void removeEdge(String from, String to) {
        adjacencyNodes.get(nodeMap.get(from)).remove(nodeMap.get(to));
    }

    //递归深度优先遍历图
    public void traversalDepthFirstRec(String root) {
        Node node = nodeMap.get(root);
        if (node == null)
            return;
        traversalDepthFirstRec(node, new HashSet<>());

    }

    private void traversalDepthFirstRec(Node root, Set<Node> set) {
        System.out.print(root.label + " ");
        set.add(root);

        for (Node node : adjacencyNodes.get(root)) {
            if (!set.contains(node))
                traversalDepthFirstRec(node, set);
        }
    }

    //使用迭代实现图的深度优先遍历
    public void traverseDepthFirstIte(String root) {
        Node node = nodeMap.get(root);
        if (node == null)
            return;

        Set<Node> set = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            Node current = stack.pop();

            if (set.contains(current))
                continue;

            System.out.print(current + " ");
            set.add(current);

            for (Node neighbour : adjacencyNodes.get(current)) {
                if (!set.contains(neighbour))
                    stack.push(neighbour);
            }
        }

    }

    public void traversalBreadthFirst(String label) {
        Node node = nodeMap.get(label);
        if (node == null)
            return;

//        traversalBreadthFirst(node, new ArrayDeque<>());
        Set<Node> set = new HashSet<>();
        Queue<Node> queue = new ArrayDeque<>();

        queue.add(node);
        set.add(node);
        while (!queue.isEmpty()) {
            Node current = queue.remove();

            for (Node neighbour : adjacencyNodes.get(current)) {
                if (!set.contains(neighbour)) {
                    set.add(neighbour);
                    queue.add(neighbour);
                }
            }

            System.out.print(current + " ");
        }
    }


    /**
     * 一个有向图能进行拓扑排序的充要条件是，它是一个有向、无环图，Directed Acyclic Graph
     * 拓扑排序的思路 ：
     *      找到入度为0的点，然后把他储存后在图里删掉。
     *      那么这个点的 next 里面的点入度就减少1
     *      继续找入度为0的点重复上述步骤。
     * Head : 不依赖其它节点
     * Tail ：不被其它节点所依赖
     */

    //有向无环图的拓扑排序
    public List<String> topologicalSort() {
        List<String> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Set<Node> set = new HashSet<>();

        for (Node node : nodeMap.values()) {
            topologicalSort(node, set, stack);
        }

        while (!stack.isEmpty()) {
            list.add(stack.pop().label);
        }
        return list;
    }

    private void topologicalSort(Node node, Set<Node> set, Stack<Node> stack) {
        if (set.contains(node))
            return;
        set.add(node);

        for (Node neighbour : adjacencyNodes.get(node)) {
            topologicalSort(neighbour, set, stack);
        }

        stack.push(node);
    }

/*
    private void traversalBreadthFirst(Node node, Queue<Node> queue) {
        System.out.print(node + " ");

        queue.add(node);
        for (Node neighbour : adjacencyNodes.get(node)) {
            if (!queue.contains(neighbour)) {
                System.out.print(neighbour + " ");
                queue.add(neighbour);
            }
        }
        for (Node que : queue) {
            for (Node neighbour : adjacencyNodes.get(que)) {
                if (!queue.contains(neighbour)) {
                    traversalBreadthFirst(neighbour, queue);
                }
            }
        }
    }
*/



    public void print() {
        for (Map.Entry<Node, List<Node>> map : adjacencyNodes.entrySet()) {
            if (map.getValue().size() != 0){
                System.out.println(map.getKey() + " is connected with " + Arrays.toString(map.getValue().toArray()));
            }
        }
    }
}
