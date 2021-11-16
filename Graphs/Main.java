package Graphs;

/**
 * @author BianWenKai
 * @DATE 2021/11/14 - 17:37
 **/
public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addEdge("A", "B");
        graph.addEdge("B", "C");
        graph.addEdge("C", "A");
        graph.addEdge("A", "D");

//        graph.removeNode("B");
//        graph.removeEdge("A","B");

        graph.print();

        graph.traversalDepthFirstRec("A");
        System.out.println();
        graph.traversalDepthFirstRec("C");
        System.out.println();

        graph.traverseDepthFirstIte("A");
        System.out.println();
        graph.traverseDepthFirstIte("C");

        System.out.println();
        System.out.println("================");
        graph.traversalBreadthFirst("A");


        System.out.println();
        System.out.println("================");
        System.out.println(graph.topologicalSort());

        System.out.println("================");
        System.out.println(graph.hasCycle());
    }
}