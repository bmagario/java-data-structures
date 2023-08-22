package com.bmagario.data_structures.circular_linked_list;

public class CircularLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;

    public CircularLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);

        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            newNode.setNext(newNode);
        } else {
            newNode.setNext(this.head);
            this.tail.setNext(newNode);
            this.tail = newNode;
        }
    }

    public T get(int index) {
        Node<T> currentNode = this.head;

        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }

        return currentNode.getData();
    }

    public void remove(int index) {
        if (index == 0) {
            this.head = this.head.getNext();
            this.tail.setNext(this.head);
        } else {
            Node<T> previousNode = this.head;

            for (int i = 0; i < index - 1; i++) {
                previousNode = previousNode.getNext();
            }

            previousNode.setNext(previousNode.getNext().getNext());
        }
    }
}
