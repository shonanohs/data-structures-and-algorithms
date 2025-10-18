package data_structures.linked_lists;

import data_structures.Node;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int length;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (tail != null) {
            tail.setNext(newNode);
            newNode.setPrev(tail);
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
            head.setPrev(newNode);
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

        nodeToInsert.setPrev(previousNode);
        nodeToInsert.setNext(nextNode);
        previousNode.setNext(nodeToInsert);
        nextNode.setPrev(nodeToInsert);

        length++;
    }

    public void remove(int index) {
        // Check input
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + length);
        }
        if (index == 0) {
            head = head.getNext();
            if (head != null) {
                head.setPrev(null);
            }
            else {
                tail = null;
            }
            length--;
            return;
        }

        Node previousNode = getNodeAt(index - 1);
        Node nodeToRemove = previousNode.getNext();
        Node nextNode = nodeToRemove.getNext();

        previousNode.setNext(nextNode);
        if (nextNode != null) {
            nextNode.setPrev(previousNode);
        }
        else {
            tail = previousNode;
        }

        length--;
    }

    private Node getNodeAt(int index) {
        if (index < length / 2) {
            Node currentNode = head;
            for (int i = 0; i < index; i++) currentNode = currentNode.getNext();
            return currentNode;
        } else {
            Node currentNode = tail;
            for (int i = length - 1; i > index; i--) currentNode = currentNode.getPrev();
            return currentNode;
        }
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
                sb.append(" <-> ");
            }
            currentNode = currentNode.getNext();
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.append(10);
        doublyLinkedList.append(20);
        System.out.println(doublyLinkedList); // [10 <-> 20]
        doublyLinkedList.prepend(30);
        System.out.println(doublyLinkedList); // [30 <-> 10 <-> 20]
        doublyLinkedList.insert(1, 50);
        System.out.println(doublyLinkedList); // [30 <-> 50 <-> 10 <-> 20]
        doublyLinkedList.remove(0);
        System.out.println(doublyLinkedList); // [50 <-> 10 <-> 20]
        System.out.println(doublyLinkedList.getLength()); // 3
        System.out.println(doublyLinkedList.get(1)); // 10
        System.out.println(doublyLinkedList.get(3)); // IndexOutOfBoundsException
    }
}
