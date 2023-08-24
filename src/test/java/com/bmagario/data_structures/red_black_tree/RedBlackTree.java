package com.bmagario.data_structures.red_black_tree;

public class RedBlackTree<T extends Comparable<T>> {

    private Node<T> root;

    public RedBlackTree() {
        this.root = null;
    }

    public void insert(T data) {
        Node<T> newNode = new Node<>(data);
        this.root = insert(this.root, newNode);
    }

    private Node<T> insert(Node<T> node, Node<T> newNode) {
        if (node == null) {
            return newNode;
        }

        int compareResult = newNode.getData().compareTo(node.getData());

        if (compareResult < 0) {
            node.setLeft(insert(node.getLeft(), newNode));
        } else if (compareResult > 0) {
            node.setRight(insert(node.getRight(), newNode));
        } else {
            // The data already exists in the tree.
        }

        // Balance the tree.
        node = balance(node);

        return node;
    }

    private Node<T> balance(Node<T> node) {
        int balanceFactor = getBalanceFactor(node);

        if (balanceFactor > 1) {
            if (getBalanceFactor(node.getLeft()) >= 0) {
                return rightRotate(node);
            } else {
                return leftRightRotate(node);
            }
        } else if (balanceFactor < -1) {
            if (getBalanceFactor(node.getRight()) <= 0) {
                return leftRotate(node);
            } else {
                return rightLeftRotate(node);
            }
        }

        return node;
    }

    private int getBalanceFactor(Node<T> node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = (node.getLeft() != null) ? node.getLeft().getHeight() : 0;
        int rightHeight = (node.getRight() != null) ? node.getRight().getHeight() : 0;

        return leftHeight - rightHeight;
    }

    private Node<T> rightRotate(Node<T> node) {
        Node<T> leftChild = node.getLeft();
        node.setLeft(leftChild.getRight());
        leftChild.setRight(node);

        node.setHeight(1 + Math.max(node.getLeft().getHeight(), node.getRight().getHeight()));
        leftChild.setHeight(
                1 + Math.max(leftChild.getLeft().getHeight(), leftChild.getRight().getHeight()));

        return leftChild;
    }

    private Node<T> leftRotate(Node<T> node) {
        Node<T> rightChild = node.getRight();
        node.setRight(rightChild.getLeft());
        rightChild.setLeft(node);

        node.setHeight(1 + Math.max(node.getLeft().getHeight(), node.getRight().getHeight()));
        rightChild.setHeight(
                1 + Math.max(rightChild.getLeft().getHeight(), rightChild.getRight().getHeight()));

        return rightChild;
    }

    private Node<T> rightLeftRotate(Node<T> node) {
        node.setRight(rightRotate(node.getRight()));
        return leftRotate(node);
    }

    private Node<T> leftRightRotate(Node<T> node) {
        node.setLeft(leftRotate(node.getLeft()));
        return rightRotate(node);
    }

    public boolean search(T data) {
        Node<T> node = this.root;

        while (node != null) {
            int compareResult = data.compareTo(node.getData());

            if (compareResult < 0) {
                node = node.getLeft();
            } else if (compareResult > 0) {
                node = node.getRight();
            } else {
                // The data was found.
                return true;
            }
        }

        // The data was not found.
        return false;
    }

    public Node<T> getRoot() {
        return root;
    }

    public T getRootLeftData() {
        return root.getLeft().getData();
    }

    public T getRootRightData() {
        return root.getRight().getData();
    }

    public T getRootData() {
        if (this.root == null) {
            return null;
        }

        return this.root.getData();
    }
}
