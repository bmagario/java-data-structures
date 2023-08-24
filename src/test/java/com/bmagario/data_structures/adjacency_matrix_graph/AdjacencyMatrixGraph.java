package com.bmagario.data_structures.adjacency_matrix_graph;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyMatrixGraph<T extends Comparable<T>> {

    private int[][] adjacencyMatrix;
    private List<Vertex<T>> vertices;

    public AdjacencyMatrixGraph(int numVertices) {
        this.adjacencyMatrix = new int[numVertices][numVertices];
        this.vertices = new ArrayList<>();
    }

    public void addVertex(T data) {
        Vertex<T> vertex = new Vertex<>(data);
        vertices.add(vertex);

        for (int i = 0; i < adjacencyMatrix.length; i++) {
            adjacencyMatrix[i][i] = 0;
        }
    }

    public void addEdge(T source, T destination) {
        Vertex<T> sourceVertex = getVertex(source);
        Vertex<T> destinationVertex = getVertex(destination);

        int sourceIndex = vertices.indexOf(sourceVertex);
        int destinationIndex = vertices.indexOf(destinationVertex);

        adjacencyMatrix[sourceIndex][destinationIndex] = 1;
        adjacencyMatrix[destinationIndex][sourceIndex] = 1;
    }

    public Vertex<T> getVertex(T data) {
        return vertices.stream()
                .filter(vertex -> data.compareTo(vertex.getData()) == 0)
                .findFirst()
                .orElse(null);
    }

    public int[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }

    public List<Vertex<T>> getVertices() {
        return vertices;
    }
}