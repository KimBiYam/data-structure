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

    public Object removeFirst() {
        Node temp = head;
        head = temp.next;
        Object tempData = temp.data;
        temp = null;
        size--;
        return tempData;
    }

    public Object remove(int k) {
        if (k == 0) {
            return removeFirst();
        }

        Node prev = node(k - 1);
        Node temp = prev.next;
        prev.next = temp.next;
        Object tempData = temp.data;
        if (tail == temp) {
            tail = prev;
        }
        temp = null;
        size--;

        return tempData;
    }

    public Object removeLast() {
        return remove(size - 1);
    }

    public int size() {
        return size;
    }

    public Object get(int k) {
        return node(k);
    }

    public int indexOf(Object data) {
        Node temp = head;
        int index = 0;

        while (temp.data != data) {
            temp = temp.next;
            index++;
            if (temp == null) {
                return -1;
            }
        }
        return index;
    }

    public ListIterator listIterator() {
        return new ListIterator();
    }

    public class ListIterator {
        private Node next;
        private Node lastReturned;
        private int nextIndex = 0;

        ListIterator() {
            next = head;
        }

        public Object next() {
            lastReturned = next;
            next = next.next;
            nextIndex++;
            return lastReturned.data;
        }

        public boolean hasNext() {
            return nextIndex < size;
        }

        public void add(Object input) {
            Node newNode = new Node(input);

            if (lastReturned == null) {
                head = newNode;
                newNode.next = next;
            } else {
                lastReturned.next = newNode;
                newNode.next = next;
            }

            lastReturned = newNode;
            nextIndex++;
            size++;
        }

        public void remove() {
            if (nextIndex == 0) {
                throw new IllegalStateException();
            }
            LinkedList.this.remove(nextIndex - 1);
            nextIndex--;
        }


    }


}
