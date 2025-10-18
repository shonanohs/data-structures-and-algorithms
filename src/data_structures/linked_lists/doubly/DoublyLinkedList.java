package data_structures.linked_lists.doubly;

public class DoublyLinkedList {
    private DoublyLinkedNode head;
    private DoublyLinkedNode tail;
    private int length;

    public DoublyLinkedList(int value) {
        this.head = new DoublyLinkedNode(value);
        this.tail = this.head;
        this.length = 1;
    }

    public void append(int value) {
        DoublyLinkedNode newNode = new DoublyLinkedNode(value);
        tail.setNext(newNode);
        newNode.setPrev(tail);
        tail = newNode;
        length++;
    }

    public void prepend(int value) {
        DoublyLinkedNode newNode = new DoublyLinkedNode(value);
        newNode.setNext(head);
        head.setPrev(newNode);
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

        DoublyLinkedNode previousNode = getNodeAt(index - 1);
        DoublyLinkedNode nextNode = previousNode.getNext();
        DoublyLinkedNode nodeToInsert = new DoublyLinkedNode(value);

        nodeToInsert.setPrev(previousNode);
        nodeToInsert.setNext(nextNode);
        previousNode.setNext(nodeToInsert);
        nextNode.setPrev(nodeToInsert);

        length++;
    }

    public void remove(int index) {
        // Check input
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + length);
        }
        if (index == 0) {
            head = head.getNext();
            if (head != null) {
                head.setPrev(null);
            }
            else {
                tail = null;
            }
            length--;
            return;
        }

        DoublyLinkedNode previousNode = getNodeAt(index - 1);
        DoublyLinkedNode nodeToRemove = previousNode.getNext();
        DoublyLinkedNode nextNode = nodeToRemove.getNext();

        previousNode.setNext(nextNode);
        if (nextNode != null) {
            nextNode.setPrev(previousNode);
        }
        else {
            tail = previousNode;
        }

        length--;
    }

    private DoublyLinkedNode getNodeAt(int index) {
        DoublyLinkedNode currentNode = head;
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
        DoublyLinkedNode currentNode = head;
        while (currentNode != null) {
            sb.append(currentNode.getValue());
            if (currentNode.getNext() != null) {
                sb.append(" <-> ");
            }
            currentNode = currentNode.getNext();
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList(10);
        doublyLinkedList.append(20);
        System.out.println(doublyLinkedList); // [10 <-> 20]
        doublyLinkedList.prepend(30);
        System.out.println(doublyLinkedList); // [30 <-> 10 <-> 20]
        doublyLinkedList.insert(1, 50);
        System.out.println(doublyLinkedList); // [30 <-> 50 <-> 10 <-> 20]
        doublyLinkedList.remove(0);
        System.out.println(doublyLinkedList); // [50 <-> 10 <-> 20]
        System.out.println(doublyLinkedList.getLength()); // 3
        System.out.println(doublyLinkedList.get(1)); // 10
        System.out.println(doublyLinkedList.get(3)); // IndexOutOfBoundsException
    }
}
