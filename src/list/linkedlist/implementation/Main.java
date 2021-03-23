package list.linkedlist.implementation;

public class Main {
    public static void main(String[] args) {
        LinkedList numbers = new LinkedList();
        numbers.addLast(10);
        numbers.addLast(20);
        numbers.addLast(30);


        LinkedList.ListIterator iterator = numbers.listIterator();
        while (iterator.hasNext()) {
            if ((int) iterator.next() == 20) {
                iterator.remove();
            }
        }

        System.out.println(numbers);

    }
}
