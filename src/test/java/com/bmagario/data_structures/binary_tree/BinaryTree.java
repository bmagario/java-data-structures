package com.bmagario.data_structures.binary_tree;

public class BinaryTree<T extends Comparable<T>> {

    private Node<T> root;

    public BinaryTree() {
        this.root = null;
    }

    public void insert(T data) {
        Node<T> newNode = new Node<>(data);

        if (this.root == null) {
            this.root = newNode;
        } else {
            insert(this.root, newNode);
        }
    }

    private void insert(Node<T> node, Node<T> newNode) {
        if (newNode.getData().compareTo(node.getData()) < 0) {
            if (node.getLeft() == null) {
                node.setLeft(newNode);
            } else {
                insert(node.getLeft(), newNode);
            }
        } else {
            if (node.getRight() == null) {
                node.setRight(newNode);
            } else {
                insert(node.getRight(), newNode);
            }
        }
    }

    public boolean search(T data) {
        return search(this.root, data);
    }

    private boolean search(Node<T> node, T data) {
        if (node == null) {
            return false;
        }

        if (data.compareTo(node.getData()) == 0) {
            return true;
        } else if (data.compareTo(node.getData()) < 0) {
            return search(node.getLeft(), data);
        } else {
            return search(node.getRight(), data);
        }
    }

    public void delete(T data) {
        delete(this.root, data);
    }

    private void delete(Node<T> node, T data) {
        if (node == null) {
            return;
        }

        if (data.compareTo(node.getData()) == 0) {
            if (node.getLeft() == null && node.getRight() == null) {
                node = null;
            } else if (node.getLeft() == null) {
                node = node.getRight();
            } else if (node.getRight() == null) {
                node = node.getLeft();
            } else {
                Node<T> successor = getMin(node.getRight());
                node.setData(successor.getData());
                delete(node.getRight(), successor.getData());
            }
        } else if (data.compareTo(node.getData()) < 0) {
            delete(node.getLeft(), data);
        } else {
            delete(node.getRight(), data);
        }
    }

    private Node<T> getMin(Node<T> node) {
        if (node.getLeft() == null) {
            return node;
        } else {
            return getMin(node.getLeft());
        }
    }

    public T getRootData() {
        if (this.root == null) {
            return null;
        }

        return this.root.getData();
    }
}
