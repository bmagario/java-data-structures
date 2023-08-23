package com.bmagario.data_structures.tree;

public class Tree<T extends Comparable<T>> {

    private Node<T> root;

    public Tree() {
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

    public void inorderTraversal() {
        inorderTraversal(this.root);
    }

    private void inorderTraversal(Node<T> node) {
        if (node != null) {
            inorderTraversal(node.getLeft());
            System.out.println(node.getData().toString());
            inorderTraversal(node.getRight());
        }
    }

    public void preorderTraversal() {
        preorderTraversal(this.root);
    }

    private void preorderTraversal(Node<T> node) {
        if (node != null) {
            System.out.println(node.getData().toString());
            preorderTraversal(node.getLeft());
            preorderTraversal(node.getRight());
        }
    }

    public void postorderTraversal() {
        postorderTraversal(this.root);
    }

    private void postorderTraversal(Node<T> node) {
        if (node != null) {
            postorderTraversal(node.getLeft());
            postorderTraversal(node.getRight());
            System.out.println(node.getData().toString());
        }
    }

    public Node<T> getRoot() {
        return this.root;
    }
}
