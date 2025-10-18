package data_structures.linked_lists.singly;

public class SinglyLinkedList {
    private SinglyLinkedNode head;
    private SinglyLinkedNode tail;
    private int length;

    public SinglyLinkedList(int value) {
        this.head = new SinglyLinkedNode(value);
        this.tail = this.head;
        this.length = 1;
    }

    public void append(int value) {
        SinglyLinkedNode newNode = new SinglyLinkedNode(value);
        tail.setNext(newNode);
        tail = newNode;
        length++;
    }

    public void prepend(int value) {
        SinglyLinkedNode newNode = new SinglyLinkedNode(value);
        newNode.setNext(head);
        head = newNode;
        length++;
    }

    public void insert(int index, int value) {
        // Check input
        if (index == 0) {
            prepend(value);
            return;
        } else if (index == length) {
            append(value);
            return;
        }
        else if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + length);
        }

        SinglyLinkedNode previousNode = getNodeAt(index - 1);
        SinglyLinkedNode nodeToInsert = new SinglyLinkedNode(value);
        nodeToInsert.setNext(previousNode.getNext());
        previousNode.setNext(nodeToInsert);
        length++;
    }

    public void remove(int index) {
        // Check input
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + length);
        }
        if (index == 0) {
            head = head.getNext();
            length--;
            return;
        }

        SinglyLinkedNode previousNode = getNodeAt(index - 1);
        previousNode.setNext(previousNode.getNext().getNext());
        if (index == length - 1) {
            tail = previousNode;
        }
        length--;
    }

    private SinglyLinkedNode getNodeAt(int index) {
        SinglyLinkedNode currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }

    public int get(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + length);
        }
        return getNodeAt(index).getValue();
    }

    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        SinglyLinkedNode currentNode = head;
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
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList(10);
        singlyLinkedList.append(20);
        System.out.println(singlyLinkedList); // [10 -> 20]
        singlyLinkedList.prepend(30);
        System.out.println(singlyLinkedList); // [30 -> 10 -> 20]
        singlyLinkedList.insert(1, 50);
        System.out.println(singlyLinkedList); // [30 -> 50 -> 10 -> 20]
        singlyLinkedList.remove(0);
        System.out.println(singlyLinkedList); // [50 -> 10 -> 20]
        System.out.println(singlyLinkedList.getLength()); // 3
        System.out.println(singlyLinkedList.get(1)); // 10
        System.out.println(singlyLinkedList.get(3)); // IndexOutOfBoundsException
    }
}
