package data_structures.arrays;

public class DynamicArray {
    private int length;
    private String[] data;
    private int capacity;

    public DynamicArray() {
        length = 0; // number of items currently in the array
        capacity = 1; // how many items the array can hold
        data = new String[capacity];
    }

    public String get(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
        }
        return data[index];
    }

    public void push(String item) {
        if (capacity == length) {
            capacity *= 2; // Double capacity of array when full
            String[] newData = new String[capacity];
            for (int i = 0; i < length; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
        data[length] = item;
        length++;
    }

    public String pop() {
        if (length == 0) {
            throw new IllegalStateException("Array is empty");
        }
        String itemToPop = data[length - 1];
        data[length - 1] = null;
        length--;
        return itemToPop;
    }

    public String delete(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
        }
        String itemToDelete = data[index];
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
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.push("hello");
        dynamicArray.push("world");
        dynamicArray.push("!");
        System.out.println(dynamicArray); // [hello, world, !]

        dynamicArray.pop();
        System.out.println(dynamicArray); // [hello, world]

        dynamicArray.delete(1);
        System.out.println(dynamicArray); // [hello]

        System.out.println(dynamicArray.get(0)); // hello
    }
}

