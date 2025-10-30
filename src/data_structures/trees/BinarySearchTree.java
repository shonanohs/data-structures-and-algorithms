package data_structures.trees;

import data_structures.Node;

import java.util.*;

public class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public enum DFS { INORDER, PREORDER, POSTORDER }

    private Node insertRec(Node current, int value) {
        if (current == null) return new Node(value);
        // Traverse tree to left (prev) or right (next) of current node until a
        // 'null' node/empty space is found to insert into
        if (value < current.getValue()) {
            current.setPrev(insertRec(current.getLeft(), value));
        }
        else {
            current.setNext(insertRec(current.getRight(), value));
        }
        return current;
    }

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node lookupRec(Node current, int value) {
        if (current == null) return null;
        if (value == current.getValue()) return current;
        // Traverse tree to left (prev) or right (next) of current node until
        // its value matches the input value
        if (value < current.getValue()) {
            return lookupRec(current.getLeft(), value);
        }
        else {
            return lookupRec(current.getRight(), value);
        }
    }

    public Node lookup(int value) { return lookupRec(root, value); }

    private Node removeRec(Node current, int value) {
        if (current == null) return null;

        if (value < current.getValue()) {
            current.setPrev(removeRec(current.getLeft(), value));
        } else if (value > current.getValue()) {
            current.setNext(removeRec(current.getRight(), value));
        } else {
            // Case 1: no children
            if (current.getLeft() == null && current.getRight() == null) return null;

            // Case 2: only one child
            if (current.getLeft() == null) return current.getRight();
            if (current.getRight() == null) return current.getLeft();

            // Case 3: two children
            // Find in-order successor (smallest value in right subtree)
            Node smallest = findMin(current.getRight());
            current.setValue(smallest.getValue());
            current.setNext(removeRec(current.getRight(), smallest.getValue()));
        }

        return current;
    }

    private Node findMin(Node node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }

    public void remove(int value) {
        root = removeRec(root, value);
    }

    private List<Integer> breadthFirstSearch() {
        if (root == null) return new ArrayList<>();
        Node currentNode = root;
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();

        queue.add(currentNode);

        while (!queue.isEmpty()) {
            currentNode = queue.remove();
            list.add(currentNode.getValue());

            if (currentNode.getLeft() != null) queue.add(currentNode.getLeft());
            if (currentNode.getRight() != null) queue.add(currentNode.getRight());
        }
        return list;
    }

    /*
        Wrapper method to create queue/list for BFS recursive call
     */
    public List<Integer> breadthFirstSearchRec() {
        if (root == null) return new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        return breadthFirstSearchRec(queue, new ArrayList<>());
    }

    public List<Integer> breadthFirstSearchRec(Queue<Node> queue, List<Integer> list) {
        if (queue.isEmpty()) return list;

        Node currentNode = queue.remove();
        list.add(currentNode.getValue());

        if (currentNode.getLeft() != null) queue.add(currentNode.getLeft());
        if (currentNode.getRight() != null) queue.add(currentNode.getRight());

        return breadthFirstSearchRec(queue, list);
    }

    /*
        Wrapper method to create list/pass in root node for DFS recursive call
        according to desired type
     */
    public List<Integer> depthFirstSearch(DFS type) {
        if (root == null) return new ArrayList<>();
        return switch (type) {
            case INORDER -> depthFirstSearchInOrder(root, new ArrayList<>());
            case POSTORDER -> depthFirstSearchPostOrder(root, new ArrayList<>());
            case PREORDER -> depthFirstSearchPreOrder(root, new ArrayList<>());
            default -> null;
        };
    }

    private List<Integer> depthFirstSearchInOrder(Node node, List<Integer> list) {
        if (node.getLeft() != null) {
            depthFirstSearchInOrder(node.getLeft(), list);
        }
        list.add(node.getValue());
        if (node.getRight() != null) {
            depthFirstSearchInOrder(node.getRight(), list);
        }
        return list;
    }

    private List<Integer> depthFirstSearchPostOrder(Node node, List<Integer> list) {
        if (node.getLeft() != null) {
            depthFirstSearchPostOrder(node.getLeft(), list);
        }
        if (node.getRight() != null) {
            depthFirstSearchPostOrder(node.getRight(), list);
        }
        list.add(node.getValue());
        return list;
    }

    private List<Integer> depthFirstSearchPreOrder(Node node, List<Integer> list) {
        list.add(node.getValue());
        if (node.getLeft() != null) {
            depthFirstSearchPreOrder(node.getLeft(), list);
        }
        if (node.getRight() != null) {
            depthFirstSearchPreOrder(node.getRight(), list);
        }
        return list;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        printTree(root, sb, "", true);
        return sb.toString();
    }

    private void printTree(Node node, StringBuilder sb, String prefix, boolean isTail) {
        if (node == null) return;
        if (node.getRight() != null) {
            printTree(node.getRight(), sb, prefix + (isTail ? "│   " : "    "), false);
        }
        sb.append(prefix).append(isTail ? "└── " : "┌── ").append(node.getValue()).append("\n");
        if (node.getLeft() != null) {
            printTree(node.getLeft(), sb, prefix + (isTail ? "    " : "│   "), true);
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

        // Breadth-First Search
        System.out.println(bst.breadthFirstSearch()); // [9, 4, 170, 1, 6]
        System.out.println(bst.breadthFirstSearchRec()); // [9, 4, 170, 1, 6]
        // Depth-First Search
        System.out.println(bst.depthFirstSearch(DFS.INORDER)); // [1, 4, 6, 9, 170]
        System.out.println(bst.depthFirstSearch(DFS.PREORDER)); // [9, 4, 1, 6, 170]
        System.out.println(bst.depthFirstSearch(DFS.POSTORDER)); // [1, 6, 4, 170, 9]
    }
}
