package array.list;

import java.util.ArrayList;
import java.util.Iterator;


class Main {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
        System.out.println("add(값)");
        System.out.println(numbers);

        numbers.add(1, 50);
        System.out.printf("\nadd(%s, %s)\n", "인덱스", "값");
        System.out.println(numbers);

        numbers.remove(2);
        System.out.printf("\nremove(%s)\n", "인덱스");
        System.out.println(numbers);

        System.out.printf("\nget(%s)\n", "인덱스");
        System.out.println(numbers.get(2));
        System.out.println(numbers.size());

        Iterator numbersIterator = numbers.iterator();
        while (numbersIterator.hasNext()) {
            int value = (int) numbersIterator.next();
            if (value == 30) {
                numbersIterator.remove();
            }
            System.out.println(value);
        }
        System.out.println(numbers);

        System.out.println("\nfor each");
        for (int value : numbers) {
            System.out.println(value);
        }
    }

}