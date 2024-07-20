package les4.first;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat(Male.MALE);
        Cat cat2 = new Cat(Male.FEMALE);
        Cat cat3 = new Cat(Male.MALE);
        Cat cat4 = new Cat(Male.FEMALE);

        Cat[] cats = {cat1, cat2, cat3, cat4};
        List<Cat> catList = Arrays.asList(cats);

        for (Cat cat: catList) {
            switch (cat.getMale()){
                case MALE -> System.out.println("Кот");
                case FEMALE -> System.out.println("Кошка");
            }
        }

        Iterator<Cat> iterator = catList.iterator();
        while(iterator.hasNext()){
            Cat cat = iterator.next();

            switch (cat.getMale()){
                case MALE -> System.out.println("Кот");
                case FEMALE -> System.out.println("Кошка");
            }
        }

    }
}
