package data_structures.queues;

import java.util.NoSuchElementException;
import java.util.Stack;

public class QueueStack {
    private Stack<Integer> enqueueStack;
    private Stack<Integer> dequeueStack;
    private int length;

    public QueueStack() {
        this.enqueueStack = new Stack<>();
        this.dequeueStack = new Stack<>();
        this.length = 0;
    }

    public void enqueue(int value) {
        enqueueStack.push(value);
        length++;
    }

    public int dequeue() {
        if (dequeueStack.isEmpty() && enqueueStack.isEmpty()) {
            throw new NoSuchElementException();
        }
        // Transfer elements from enqueue to dequeue stack if dequeue stack is empty
        if (dequeueStack.isEmpty()) {
            while (!enqueueStack.isEmpty()) {
                dequeueStack.push(enqueueStack.pop());
            }
        }
        length--;
        return dequeueStack.pop();
    }

    public int peek() {
        // Transfer elements from enqueue to dequeue stack if dequeue stack is empty
        if (dequeueStack.isEmpty()) {
            while (!enqueueStack.isEmpty()) {
                dequeueStack.push(enqueueStack.pop());
            }
        }
        return dequeueStack.peek();
    }

    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("(front) [");
        int total = dequeueStack.size() + enqueueStack.size();

        // Print dequeueStack from top to bottom
        for (int i = dequeueStack.size() - 1; i >= 0; i--) {
            sb.append(dequeueStack.get(i));
            if (--total > 0) sb.append(" -> ");
        }

        // Print enqueueStack from bottom to top
        for (int i = 0; i < enqueueStack.size(); i++) {
            sb.append(enqueueStack.get(i));
            if (--total > 0) sb.append(" -> ");
        }

        sb.append("]");
        return sb.toString();
    }


    public static void main(String[] args) {
        QueueStack queue = new QueueStack();
        queue.enqueue(10);
        System.out.println(queue); // (front) [10]
        queue.enqueue(20);
        System.out.println(queue); // (front) [10 -> 20]
        queue.enqueue(30);
        System.out.println(queue); // (front) [10 -> 20 -> 30]

        System.out.println(queue.dequeue()); // 10
        System.out.println(queue); // (front) [20 -> 30]
        System.out.println(queue.peek()); // 20
        System.out.println(queue.getLength()); // 2
    }
}
