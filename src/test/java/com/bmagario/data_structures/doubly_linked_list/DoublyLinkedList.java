package com.bmagario.data_structures.doubly_linked_list;

public class DoublyLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);

        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.setNext(newNode);
            newNode.setPrev(this.tail);
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
        } else {
            Node<T> previousNode = this.head;

            for (int i = 0; i < index - 1; i++) {
                previousNode = previousNode.getNext();
            }

            previousNode.setNext(previousNode.getNext().getNext());
            previousNode.getNext().setPrev(previousNode);
        }
    }
}
