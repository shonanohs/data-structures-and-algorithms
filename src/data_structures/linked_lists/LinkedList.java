package data_structures.linked_lists;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    public LinkedList(int value) {
        this.head = new Node();
        this.head.setValue(value);
        this.tail = this.head;
        this.length = 1;
    }

    public void append(int value) {
        Node nodeToAppend = new Node();
        nodeToAppend.setValue(value);
        tail.setNext(nodeToAppend);
        tail = nodeToAppend;
        length++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node currentNode = head;
        for (int i =0; i < length; i++) {
            sb.append(currentNode.getValue());
            sb.append(" -> ");
            currentNode = currentNode.getNext();
        }
        sb.append("null]");
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(10);
        linkedList.append(20);
        System.out.println(linkedList);
    }
}
