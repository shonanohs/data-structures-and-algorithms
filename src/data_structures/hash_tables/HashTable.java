package data_structures.hash_tables;

import java.util.ArrayList;

public class HashTable {
    ArrayList<KeyValue>[] data;
    private int currentLength;

    public HashTable(int size) {
        this.data = new ArrayList[size];
        this.currentLength = 0;
    }

    public void set(String key, int value) {
        int address = hash(key);
        if (data[address] == null) {
            ArrayList<KeyValue> arrayAtAddress = new ArrayList<>();
            data[address] = arrayAtAddress;
            currentLength++;
        }
        data[address].add(new KeyValue(key, value));
    }

    public Integer get(String key) {
        int address = hash(key);
        ArrayList<KeyValue> pair = data[address];

        if (pair == null) {
            return null;
        }
        for (KeyValue keyValue : pair) {
            if (keyValue.getKey().equals(key)) {
                return keyValue.getValue();
            }
        }
        return null;
    }

    private int hash(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash = (hash + Character.codePointAt(key, i) * i) % data.length;
        }
        return hash;
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable(10);
        hashTable.set("grapes", 10000);
        System.out.println(hashTable.get("grapes")); // 10000
        System.out.println(hashTable.get("hello")); // null
    }
}
