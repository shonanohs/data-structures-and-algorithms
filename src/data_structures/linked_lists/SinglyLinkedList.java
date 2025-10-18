package data_structures.linked_lists;

import data_structures.Node;

public class SinglyLinkedList {
    private Node head;
    private Node tail;
    private int length;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (tail != null) {
            tail.setNext(newNode);
            tail = newNode;
        } else {
            head = tail = newNode;
        }
        length++;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if (head != null) {
            newNode.setNext(head);
            head = newNode;
        } else {
            head = tail = newNode;
        }
        length++;
    }

    public void insert(int index, int value) {
        // Check input
        if (index == 0) {
            prepend(value);
            return;
        } else if (index == length) {
            append(value);
            return;
        }
        else if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + length);
        }

        Node previousNode = getNodeAt(index - 1);
        Node nextNode = previousNode.getNext();
        Node nodeToInsert = new Node(value);

        nodeToInsert.setNext(nextNode);
        previousNode.setNext(nodeToInsert);

        length++;
    }

    public void remove(int index) {
        // Check input
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + length);
        }
        if (index == 0) {
            head = head.getNext();
            length--;
            return;
        }

        Node previousNode = getNodeAt(index - 1);
        Node nodeToRemove = previousNode.getNext();

        previousNode.setNext(nodeToRemove.getNext());
        if (index == length - 1) {
            tail = previousNode;
        }
        length--;
    }

    // Time complexity: O(n)
    // Space complexity: O(1)
    public void reverse() {
        Node prevNode = null;
        Node currentNode = head;
        Node nextNode;
        tail = head;

        while (currentNode != null) {
            nextNode = currentNode.getNext();
            currentNode.setNext(prevNode);
            prevNode = currentNode;
            currentNode = nextNode;
        }

        head = prevNode;
    }

    private Node getNodeAt(int index) {
        Node currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }

    public int get(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + length);
        }
        return getNodeAt(index).getValue();
    }

    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node currentNode = head;
        while (currentNode != null) {
            sb.append(currentNode.getValue());
            if (currentNode.getNext() != null) {
                sb.append(" -> ");
            }
            currentNode = currentNode.getNext();
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.append(10);
        singlyLinkedList.append(20);
        System.out.println(singlyLinkedList); // [10 -> 20]
        singlyLinkedList.prepend(30);
        System.out.println(singlyLinkedList); // [30 -> 10 -> 20]
        singlyLinkedList.insert(1, 50);
        System.out.println(singlyLinkedList); // [30 -> 50 -> 10 -> 20]
        singlyLinkedList.remove(0);
        System.out.println(singlyLinkedList); // [50 -> 10 -> 20]
        System.out.println(singlyLinkedList.getLength()); // 3
        System.out.println(singlyLinkedList.get(1)); // 10
        singlyLinkedList.reverse();
        System.out.println(singlyLinkedList); // [20 -> 10 -> 50]
        System.out.println(singlyLinkedList.get(3)); // IndexOutOfBoundsException
    }
}
