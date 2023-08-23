package com.bmagario.data_structures.queue;

public class Queue<T> {

    private Node<T> front;
    private Node<T> rear;

    public Queue() {
        this.front = null;
        this.rear = null;
    }

    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);

        if (this.rear == null) {
            this.front = newNode;
            this.rear = newNode;
        } else {
            this.rear.setNext(newNode);
            this.rear = newNode;
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
