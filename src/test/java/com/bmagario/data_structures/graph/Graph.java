package com.bmagario.data_structures.graph;

import java.util.ArrayList;
import java.util.List;

public class Graph<T extends Comparable<T>> {

    private List<Vertex<T>> vertices;
    private List<Edge<T>> edges;

    public Graph() {
        this.vertices = new ArrayList<>();
        this.edges = new ArrayList<>();
    }

    public void addVertex(T data) {
        Vertex<T> vertex = new Vertex<>(data);
        vertices.add(vertex);
    }

    public void addEdge(T source, T destination) {
        Vertex<T> sourceVertex = getVertex(source);
        Vertex<T> destinationVertex = getVertex(destination);

        Edge<T> edge = new Edge<>(sourceVertex, destinationVertex);
        edges.add(edge);

        sourceVertex.addNeighbor(destinationVertex);
        destinationVertex.addNeighbor(sourceVertex);
    }

    public Vertex<T> getVertex(T data) {
        return vertices.stream()
                .filter(vertex -> data.compareTo(vertex.getData()) == 0)
                .findFirst()
                .orElse(null);
    }

    public List<Vertex<T>> getVertices() {
        return vertices;
    }

    public List<Edge<T>> getEdges() {
        return edges;
    }
}