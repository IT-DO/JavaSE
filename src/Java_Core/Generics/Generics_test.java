package Java_Core.Generics;

import java.util.ArrayList;
import java.util.List;

public class Generics_test {
    public static void main(String[] args) {
      //  List list =new ArrayList<>(); //RAW type - НЕЛЬЗЯ ИСПОЛЬЗОВАТЬ!
        List<String> list =new ArrayList<String>();  // Используем generics для провеки Типа данных в коллекции
        list.add("Volkswagen Polo");
        list.add("Audi A8");

       for(String o : list){  // повторная проверка, инаже  Object
           System.out.println(o + "    - Количество символов: "+ ((String)(o)).length());
       }
    }
}
