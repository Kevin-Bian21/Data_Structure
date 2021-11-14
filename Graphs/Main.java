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
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "C");
//        graph.removeNode("B");
        graph.romeEdge("A","C");

        graph.print();
    }
}
