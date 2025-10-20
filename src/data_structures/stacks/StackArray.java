package data_structures.stacks;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class StackArray {
    private ArrayList<Integer> stack;

    public StackArray() {
        this.stack = new ArrayList<>();
    }

    public Integer peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.get(stack.size() - 1);
    }

    public void push(int value) {
        stack.add(value);
    }

    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.remove(stack.size() - 1);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (Integer integer : stack) {
            sb.append(integer).append(" <- ");
        }
        if (sb.length() > 2) sb.setLength(sb.length() - 4);
        sb.append("] (top)");
        return sb.toString();
    }

    public static void main(String[] args) {
        StackArray stack = new StackArray();
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
