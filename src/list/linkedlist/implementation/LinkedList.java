package list.linkedlist.implementation;

public class LinkedList {
    private Node head;
    private Node tail;
    private int size = 0;

    private static class Node {
        private final Object data;
        private Node next;

        public Node(Object input) {
            this.data = input;
            this.next = null;
        }

        public String toString() {
            return String.valueOf(this.data);
        }
    }

    public void addFirst(Object input) {
        Node newNode = new Node(input);
        newNode.next = head;
        head = newNode;
        size++;
        if (head.next == null) {
            tail = newNode;
        }
    }

    public void addLast(Object input) {
        Node newNode = new Node(input);
        if (this.size == 0) {
            addFirst(input);
        } else {
            tail.next = newNode;
            tail = newNode;
            size++;
        }
    }

    private Node node(int index) {
        Node x = head;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }

    public void add(int k, Object input) {
        if (k == 0) {
            addFirst(input);
        } else {
            Node prev = node(k - 1);
            Node aft = prev.next;
            Node newNode = new Node(input);
            prev.next = newNode;
            newNode.next = aft;
            size++;
            if (newNode.next == null) {
                tail = newNode;
            }
        }
    }

    public String toString() {
        if (head == null) {
            return "[]";
        }

        Node temp = head;
        StringBuilder str = new StringBuilder("[");

        while (temp.next != null) {
            str.append(temp).append(',');
            temp = temp.next;
        }

        str.append(temp.data);
        return str.append("]").toString();
    }

}
