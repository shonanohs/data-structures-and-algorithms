package data_structures.queues;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class QueueArray {
    private ArrayList<Integer> queue;

    public QueueArray() {
        this.queue = new ArrayList<>();
    }

    public Integer peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return queue.get(0);
    }

    public void enqueue(int value) {
        queue.add(value);
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return queue.remove(0);
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("(front) [");
        for (Integer integer : queue) {
            sb.append(integer).append(" -> ");
        }
        if (sb.length() > 2) sb.setLength(sb.length() - 4);
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        QueueArray queue = new QueueArray();
        System.out.println(queue); // []
        queue.enqueue(10);
        System.out.println(queue); // [10]
        queue.enqueue(20);
        System.out.println(queue); // [10 -> 20]
        queue.enqueue(30);
        System.out.println(queue); // [10 -> 20 -> 30]

        System.out.println(queue.peek()); // 10
        System.out.println(queue.dequeue()); // 10
        System.out.println(queue); // [10 -> 20]
        queue.dequeue();
        queue.dequeue();
        queue.dequeue(); // NoSuchElementException
    }
}
