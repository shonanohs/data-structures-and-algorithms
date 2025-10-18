package data_structures.linked_lists.singly;

public class SinglyLinkedNode {
    private int value;
    private SinglyLinkedNode next;

    public SinglyLinkedNode(int value) {
        this.value = value;
        this.next = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public SinglyLinkedNode getNext() {
        return next;
    }

    public void setNext(SinglyLinkedNode next) {
        this.next = next;
    }
}
