package data_structures.stacks;

import data_structures.Node;

public class StackLinkedList {
    private Node head;
    private Node tail;
    private int length;

    public StackLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public void push(int value) {
        Node newNode = new Node(value);
        if (tail != null) {
            tail.setNext(newNode);
            tail = newNode;
        } else {
            head = tail = newNode;
        }
        length++;
    }

    public int pop() {
        Node newTail = getNodeAt(length - 2);
        newTail.setNext(null);
        tail = newTail;
        length--;
        return tail.getValue();
    }

    public int peek() {
        return getNodeAt(length - 1).getValue();
    }

    private Node getNodeAt(int index) {
        Node currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode;
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
                sb.append(" <- ");
            }
            currentNode = currentNode.getNext();
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        StackLinkedList stack = new StackLinkedList();
        System.out.println(stack); // []
        stack.push(10);
        System.out.println(stack); // [10]
        stack.push(20);
        System.out.println(stack); // [10 <- 20]
        stack.push(30);
        System.out.println(stack); // [10 <- 20 <- 30]

        System.out.println(stack.peek()); // 30
        System.out.println(stack.pop()); // 30
        System.out.println(stack); // [10 <- 20]
        stack.pop();
        stack.pop();
        stack.pop(); // EmptyStackException
    }
}
