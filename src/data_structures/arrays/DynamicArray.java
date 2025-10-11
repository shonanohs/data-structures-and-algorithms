package data_structures.arrays;

import java.util.Arrays;

public class DynamicArray<T> {
    private int length;
    private T[] data;
    private int capacity;

    public DynamicArray() {
        length = 0; // number of items currently in the array
        capacity = 1; // how many items the array can hold
        data = (T[]) new Object[capacity];
    }

    public T get(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
        }
        return data[index];
    }

    public void push(T item) {
        if (capacity == length) {
            capacity *= 2; // double capacity of array when full
            data = Arrays.copyOf(data, capacity);
        }
        data[length++] = item;
    }

    public T pop() {
        if (length == 0) {
            throw new IllegalStateException("Array is empty");
        }
        T itemToPop = data[length - 1];
        data[length - 1] = null;
        length--;
        return itemToPop;
    }

    public T delete(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
        }
        T itemToDelete = data[index];
        shiftItems(index);
        return itemToDelete;
    }

    public void shiftItems(int index) {
        for (int i = index; i < length - 1; i++) {
            data[i] = data[i + 1];
        }
        data[length - 1] = null;
        length--;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < length; i ++) {
            sb.append(data[i]);
            if (i < length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        // Dynamic Array of strings
        DynamicArray<String> dynamicArray = new DynamicArray<>();
        dynamicArray.push("hello");
        dynamicArray.push("world");
        dynamicArray.push("!");
        System.out.println(dynamicArray); // [hello, world, !]

        dynamicArray.pop();
        System.out.println(dynamicArray); // [hello, world]

        dynamicArray.delete(1);
        System.out.println(dynamicArray); // [hello]
        System.out.println(dynamicArray.get(0)); // hello

        // Dynamic Array of integers
        DynamicArray<Integer> dynamicArrayInt = new DynamicArray<>();
        dynamicArrayInt.push(1);
        dynamicArrayInt.push(5);
        dynamicArrayInt.push(3);
        System.out.println(dynamicArrayInt); // [1, 5, 3]

        dynamicArrayInt.pop();
        System.out.println(dynamicArrayInt); // [1, 5]

        dynamicArrayInt.delete(1);
        System.out.println(dynamicArrayInt); // [1]
        System.out.println(dynamicArrayInt.get(0)); // 1
    }
}

