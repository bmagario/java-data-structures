package com.bmagario.data_structures.stack;

public class Stack<T> {

    private Node<T> top;

    public Stack() {
        this.top = null;
    }

    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.setNext(this.top);
        this.top = newNode;
    }

    public T pop() {
        if (this.top == null) {
            return null;
        }

        T data = this.top.getData();
        this.top = this.top.getNext();
        return data;
    }

    public boolean isEmpty() {
        return this.top == null;
    }
}
