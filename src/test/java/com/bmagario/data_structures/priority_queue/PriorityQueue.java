package com.bmagario.data_structures.priority_queue;


public class PriorityQueue<T extends Comparable<T>> {

    private Node<T> front;
    private Node<T> rear;

    public PriorityQueue() {
        this.front = null;
        this.rear = null;
    }

    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);

        if (this.rear == null) {
            this.front = newNode;
            this.rear = newNode;
        } else {
            Node<T> currentNode = this.front;
            Node<T> previousNode = null;

            while (currentNode != null && data.compareTo(currentNode.getData()) >= 0) {
                previousNode = currentNode;
                currentNode = currentNode.getNext();
            }

            if (previousNode == null) {
                newNode.setNext(this.front);
                this.front = newNode;
            } else {
                previousNode.setNext(newNode);
                newNode.setNext(currentNode);
            }

            if (currentNode == null) {
                this.rear = newNode;
            }
        }
    }

    public T dequeue() {
        if (this.front == null) {
            return null;
        }

        T data = this.front.getData();
        this.front = this.front.getNext();

        if (this.front == null) {
            this.rear = null;
        }

        return data;
    }

    public boolean isEmpty() {
        return this.front == null;
    }
}
