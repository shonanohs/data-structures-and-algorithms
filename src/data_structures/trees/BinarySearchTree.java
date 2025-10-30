package data_structures.trees;

import data_structures.Node;

import java.util.*;

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

    private Node removeRec(Node current, int value) {
        if (current == null) throw new NoSuchElementException();

        if (value < current.getValue()) {
            current.setPrev(removeRec(current.getPrev(), value));
        } else if (value > current.getValue()) {
            current.setNext(removeRec(current.getNext(), value));
        } else {
            // Case 1: no children
            if (current.getPrev() == null && current.getNext() == null) return null;

            // Case 2: only one child
            if (current.getPrev() == null) return current.getNext();
            if (current.getNext() == null) return current.getPrev();

            // Case 3: two children
            // Find in-order successor (smallest value in right subtree)
            Node smallest = findMin(current.getNext());
            current.setValue(smallest.getValue());
            current.setNext(removeRec(current.getNext(), smallest.getValue()));
        }

        return current;
    }

    private Node findMin(Node node) {
        while (node.getPrev() != null) {
            node = node.getPrev();
        }
        return node;
    }

    public void remove(int value) {
        root = removeRec(root, value);
    }

    public List<Integer> breadthFirstSearch() {
        Node currentNode = root;
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();

        queue.add(currentNode);

        while (!queue.isEmpty()) {
            currentNode = queue.peek();
            queue.remove();
            list.add(currentNode.getValue());
            if (currentNode.getPrev() != null) {
                queue.add(currentNode.getPrev());
            }
            if (currentNode.getNext() != null) {
                queue.add(currentNode.getNext());
            }
        }
        return list;
    }

    public List<Integer> breadthFirstSearchRec(Queue<Node> queue, List<Integer> list) {
        if (queue.isEmpty()) {
            return list;
        }

        Node currentNode = queue.peek();
        queue.remove();
        list.add(currentNode.getValue());
        if (currentNode.getPrev() != null) {
            queue.add(currentNode.getPrev());
        }
        if (currentNode.getNext() != null) {
            queue.add(currentNode.getNext());
        }

        return breadthFirstSearchRec(queue, list);
    }

    public Node getRoot() {
        return root;
    }

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
        bst.remove(20);
        System.out.println();
        System.out.println(bst);
        /*
        │   ┌── 170
        │   │   └── 15
        └── 9
            │   ┌── 6
            └── 4
                └── 1
         */
        bst.remove(15);
        System.out.println();
        System.out.println(bst);
        /*
        │   ┌── 170
        └── 9
            │   ┌── 6
            └── 4
                └── 1
         */

        System.out.println(bst.breadthFirstSearch()); // [9, 4, 170, 1, 6]

        Queue<Node> queue = new LinkedList<>();
        queue.add(bst.getRoot());
        System.out.println(bst.breadthFirstSearchRec(queue, new ArrayList<>())); // [9, 4, 170, 1, 6]
    }
}
