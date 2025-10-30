package data_structures;

/* Common node object for use in LinkedList/Tree data structures */
public class Node {
    private Integer value;
    private Node next;
    private Node prev;

    public Node(int value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getLeft() { return this.prev; }

    public Node getRight() { return this.next; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Value: ").append(value.toString())
        .append(" Prev: ").append(prev.getValue())
        .append(" Next: ").append(next.getValue());
        return sb.toString();
    }
}
