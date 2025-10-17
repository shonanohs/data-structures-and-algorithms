package data_structures.hash_tables;

import java.util.ArrayList;

public class HashTable {
    ArrayList<KeyValue>[] data; // Store key-value pairs in an array of 'buckets'
    private int currentLength; // Track total key-value pairs

    public HashTable(int size) {
        this.data = new ArrayList[size];
        this.currentLength = 0;
    }

    public void set(String key, int value) {
        int address = hash(key);
        if (data[address] == null) {
            data[address] = new ArrayList<>();
        }

        // Update existing value if key already exists
        ArrayList<KeyValue> bucket = data[address];
        for (KeyValue keyValue : bucket) {
            if (keyValue.getKey().equals(key)) {
                keyValue.setValue(value);
                return;
            }
        }
        // Separate chaining to handle collisions - if array already
        // exists at given index, we simply add the key-value pair to the same 'bucket'
        bucket.add(new KeyValue(key, value));
        currentLength++;
    }

    public Integer get(String key) {
        int address = hash(key);
        ArrayList<KeyValue> bucket = data[address];

        if (bucket == null) {
            return null;
        }
        for (KeyValue keyValue : bucket) {
            if (keyValue.getKey().equals(key)) {
                return keyValue.getValue();
            }
        }
        return null;
    }

    public ArrayList<String> keys() {
        ArrayList<String> keys = new ArrayList<>();
        for (ArrayList<KeyValue> bucket : data) {
            if (bucket != null) {
                for (KeyValue keyValue : bucket) {
                    keys.add(keyValue.getKey());
                }
            }
        }
        return keys;
    }

    public int getCurrentLength() {
        return currentLength;
    }

    private int hash(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash = (hash + Character.codePointAt(key, i) * i) % data.length; // Keeps hash within array bounds
        }
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{ ");
        for (ArrayList<KeyValue> bucket : data) {
            if (bucket != null) {
                for (KeyValue kv : bucket) {
                    sb.append(kv.getKey()).append("=").append(kv.getValue()).append(", ");
                }
            }
        }
        if (sb.length() > 2) sb.setLength(sb.length() - 2);
        sb.append(" }");
        return sb.toString();
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable(10);
        System.out.println(hashTable); // {  }
        hashTable.set("grapes", 10000);
        System.out.println(hashTable); // { grapes=10000 }
        hashTable.set("apples", 5000);
        System.out.println(hashTable); // { grapes=10000, apples=5000 }
        hashTable.set("apples", 6000);
        System.out.println(hashTable); // { grapes=10000, apples=6000 }

        System.out.println(hashTable.get("grapes")); // 10000
        System.out.println(hashTable.get("hello")); // null
        System.out.println(hashTable.get("apples")); // 6000
        System.out.println(hashTable.keys());
        System.out.println(hashTable.getCurrentLength()); // 2
    }
}
