package Java_Core.Collections;

import java.util.HashMap;
import java.util.Map;

public class HashMapEx1 {
    public static void main(String[] args) {
        // создаем не первую Map - у
        Map<Integer, String> map1 = new HashMap<>();
        map1.put(1, "Anton Kurishchev");
        map1.put(2, "Sergei Petrov");
        map1.put(3, "Aleksei Ivanov");
        map1.put(4, "Zaur Tregulov");

        System.out.println(map1); // вывод Map
        System.out.println(map1.putIfAbsent(5, "Serg Petrov")); // вставка в Map если Key не занят
        System.out.println(map1); // вывод Map
        System.out.println(map1.get(3)); // получение элемента по ключу Key
        System.out.println(map1); // вывод Map
        System.out.println("Удаление элемента с ключем 2 " + map1.remove(3)); // удаление элемента с ключем 2
        System.out.println(map1); // вывод Map
        System.out.println("Поиск по Значению(Value): \"Sergei Petrov\": " + map1.containsValue("Sergei Petrov")); // Поиск по значению
        System.out.println("Поиск по ключу (Key): 4: " + map1.containsKey(4)); // поиск по ключу
        System.out.println("Поиск по ключу (Key): 4123: " + map1.containsKey(4123)); // пример поиска по несуществующему ключу
        System.out.println("Ввод всех ключей которыми мы пользуемся в коллекции map1: " + map1.keySet()); // вывод всех ключей которыйми мы пользуемся в коллекции map1
        System.out.println("Ввод всех значений в коллекции map1: " + map1.values()); // вывод всех значений которыйми мы пользуемся в коллекции map1


        //тест еще одной мапы
        Map<String, String> map2 = new HashMap<>();
        map2.put("Sergey", "Nachalnik");
        map2.put("Petr", "Prodavec");
        map2.put("Anton", "Programmist");
        System.out.println(map2);


    }
}
