package data_structures.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;

/* Unweighted, undirected graph */
public class Graph {
    private int numberOfNodes;
    private HashMap<Integer, ArrayList<Integer>> adjacentList;

    public Graph() {
        this.numberOfNodes = 0;
        this.adjacentList = new HashMap<>();
    }

    public void addVertex(int vertex) {
        if (adjacentList.get(vertex) != null) {
            throw new IllegalArgumentException("Vertex " + vertex + " already exists.");
        } else {
            adjacentList.put(vertex, new ArrayList<>());
            numberOfNodes++;
        }
    }

    public void addEdge(int vertex1, int vertex2) {
        if (vertex1 == vertex2) {
            throw new IllegalArgumentException("Vertices must be different.");
        }
        if (adjacentList.get(vertex1) == null || adjacentList.get(vertex2) == null) {
            throw new NoSuchElementException("One or both vertices do not exist.");
        }
        if (adjacentList.get(vertex1).contains(vertex2)) {
            throw new IllegalArgumentException("Edge already exists between nodes " + vertex1 + " and " + vertex2);
        }

        adjacentList.get(vertex1).add(vertex2);
        adjacentList.get(vertex2).add(vertex1);
    }

    public String showConnections() {
        StringBuilder sb = new StringBuilder();
        for (Integer vertex : adjacentList.keySet()) {
            sb.append(vertex).append(" --> ").append(adjacentList.get(vertex)).append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addVertex(6);

        graph.addEdge(3, 1);
        graph.addEdge(3, 4);
        graph.addEdge(4, 2);
        graph.addEdge(4, 5);
        graph.addEdge(1, 2);
        graph.addEdge(1, 0);
        graph.addEdge(0, 2);
        graph.addEdge(6, 5);

        System.out.println(graph.numberOfNodes); // 7
        System.out.println();
        System.out.println(graph.showConnections());
        /*
            0 --> [1, 2]
            1 --> [3, 2, 0]
            2 --> [4, 1, 0]
            3 --> [1, 4]
            4 --> [3, 2, 5]
            5 --> [4, 6]
            6 --> [5]
        */
    }
}
