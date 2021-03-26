package list.doublylinkedlist.implementation;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList numbers = new DoublyLinkedList();
        numbers.addLast(10);
        numbers.addLast(20);
        numbers.addLast(30);


        DoublyLinkedList.ListIterator iterator = numbers.listIterator();
        while (iterator.hasNext()) {
            if ((int) iterator.next() == 20) {
                iterator.remove();
            }
        }

        System.out.println(numbers);

    }
}
