package com.bmagario.data_structures.adjacency_matrix_graph;

class Vertex<T> {

    private T data;
    private int[] neighbors;

    public Vertex(T data) {
        this.data = data;
        this.neighbors = new int[0];
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int[] getNeighbors() {
        return neighbors;
    }

    public void addNeighbor(int neighbor) {
        this.neighbors[this.size()] = neighbor;
    }

    public int size() {
        return this.neighbors.length;
    }
}