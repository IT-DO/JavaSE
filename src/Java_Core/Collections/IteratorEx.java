package Java_Core.Collections;

import  java.util.Iterator;
import java.util.ArrayList;

public class IteratorEx {
    public static void main(String[] args) {
        ArrayList <String> arraylist = new ArrayList<>();
        arraylist.add("Anton");
        arraylist.add("Sergey");
        arraylist.add("Petr");
        arraylist.add("Igor");
        arraylist.add("Semen");
        arraylist.add("Andrei");

        Iterator <String> iterator = arraylist.iterator();
        //Вывод в консоль всех элементов
//        while(iterator.hasNext()){
//            System.out.println(iterator.next());
//       }

        // Оттличием итератора от for-loop
        // является то, что с помощью итератора,
        // мы можем удалить все элементы нашей коллекции.
        while(iterator.hasNext()){ // проверка наличия следующего элемента
            iterator.next(); //получение элемента
            iterator.remove(); // удаление полученного элемента
        }

        System.out.println(arraylist);

    }
}
