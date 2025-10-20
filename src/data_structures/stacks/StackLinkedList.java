package data_structures.stacks;

import data_structures.Node;
import java.util.EmptyStackException;

public class StackLinkedList {
    private Node top;
    private int length;

    public StackLinkedList() {
        this.top = null;
        this.length = 0;
    }

    public void push(int value) {
        Node newNode = new Node(value);
        newNode.setNext(top);
        top = newNode;
        length++;
    }

    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int value = top.getValue();
        top = top.getNext();
        length--;
        return value;
    }

    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.getValue();
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("(top) [");
        Node currentNode = top;
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
        StackLinkedList stack = new StackLinkedList();
        System.out.println(stack); // []
        stack.push(10);
        System.out.println(stack);
        stack.push(20);
        System.out.println(stack);
        stack.push(30);
        System.out.println(stack); // (top) [30 -> 20 -> 10]
        System.out.println(stack.peek()); // 30
        System.out.println(stack.pop()); // 30
        System.out.println(stack); // (top) [20 -> 10]
        System.out.println(stack.getLength()); // 2
    }
}
