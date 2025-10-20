package data_structures.trees;

import data_structures.Node;

public class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    private Node insertRec(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }
        if (value < current.getValue()) {
            current.setPrev(insertRec(current.getPrev(), value));
        } else {
            current.setNext(insertRec(current.getNext(), value));
        }
        return current;
    }

    public void insert(int value) {
        root = insertRec(root, value);
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(9);
        bst.insert(4);
        bst.insert(20);
        bst.insert(1);
        bst.insert(6);
        bst.insert(15);
        bst.insert(170);
    }
}
