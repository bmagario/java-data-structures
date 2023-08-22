package com.bmagario.data_structures.sorted_linked_list;

public class SortedLinkedList<T extends Comparable<T>> {

    private Node<T> head;

    public SortedLinkedList() {
        this.head = null;
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);

        Node<T> currentNode = this.head;
        Node<T> previousNode = null;

        while (currentNode != null && data.compareTo(currentNode.getData()) > 0) {
            previousNode = currentNode;
            currentNode = currentNode.getNext();
        }

        if (previousNode == null) {
            this.head = newNode;
        } else {
            previousNode.setNext(newNode);
        }

        newNode.setNext(currentNode);
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
        }
    }
}
