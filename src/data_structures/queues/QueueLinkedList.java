package data_structures.queues;

import data_structures.Node;

import java.util.EmptyStackException;

public class QueueLinkedList {
    private Node front;
    private Node rear;
    private int length;

    public QueueLinkedList() {
        this.front = null;
        this.rear = null;
        this.length = 0;
    }

    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.setNext(newNode);
            rear = newNode;
        }
        length++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int value = front.getValue();
        front = front.getNext();
        length--;
        return value;
    }

    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return front.getValue();
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("(front) [");
        Node currentNode = front;
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
        QueueLinkedList queue = new QueueLinkedList();
        System.out.println(queue); // []
        queue.enqueue(10);
        System.out.println(queue);
        queue.enqueue(20);
        System.out.println(queue);
        queue.enqueue(30);
        System.out.println(queue); // (front) [10 -> 20 -> 30]
        System.out.println(queue.peek()); // 10
        System.out.println(queue.dequeue()); // 10
        System.out.println(queue); // (front) [20 -> 30]
        System.out.println(queue.getLength()); // 2
    }
}
