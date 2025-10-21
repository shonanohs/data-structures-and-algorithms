package data_structures.trees;

import data_structures.Node;

import java.util.NoSuchElementException;

public class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    private Node insertRec(Node current, int value) {
        if (current == null) return new Node(value);
        // Traverse tree to left (prev) or right (next) of current node until a
        // 'null' node/empty space is found to insert into
        if (value < current.getValue()) {
            current.setPrev(insertRec(current.getPrev(), value));
        }
        else {
            current.setNext(insertRec(current.getNext(), value));
        }
        return current;
    }

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node lookupRec(Node current, int value) {
        if (current == null) throw new NoSuchElementException();
        if (value == current.getValue()) return current;
        // Traverse tree to left (prev) or right (next) of current node until
        // its value matches the input value
        if (value < current.getValue()) {
            current = lookupRec(current.getPrev(), value);
        }
        else {
            current = lookupRec(current.getNext(), value);
        }
        return current;
    }

    public Node lookup(int value) { return lookupRec(root, value); }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        printTree(root, sb, "", true);
        return sb.toString();
    }

    private void printTree(Node node, StringBuilder sb, String prefix, boolean isTail) {
        if (node == null) return;
        if (node.getNext() != null) {
            printTree(node.getNext(), sb, prefix + (isTail ? "│   " : "    "), false);
        }
        sb.append(prefix).append(isTail ? "└── " : "┌── ").append(node.getValue()).append("\n");
        if (node.getPrev() != null) {
            printTree(node.getPrev(), sb, prefix + (isTail ? "    " : "│   "), true);
        }
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
        System.out.println(bst);
        /*

        │       ┌── 170
        │   ┌── 20
        │   │   └── 15
        └── 9
            │   ┌── 6
            └── 4
                └── 1

        */
        System.out.println(bst.lookup(20)); // Value: 20 Prev: 15 Next: 170
    }
}
