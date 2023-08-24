package com.bmagario.data_structures.graph;

import java.util.ArrayList;
import java.util.List;

class Vertex<T> {

    private T data;
    private List<Vertex<T>> neighbors;

    public Vertex(T data) {
        this.data = data;
        this.neighbors = new ArrayList<>();
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<Vertex<T>> getNeighbors() {
        return neighbors;
    }

    public void addNeighbor(Vertex<T> neighbor) {
        this.neighbors.add(neighbor);
    }
}