package Java_Core.Lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        String[] arr1 = {"Пупсенок", "Медвед", "Волку делать нечего", "Даешь еще аргумент"};
        String[] arr2 = {"Лисенок", "Жираф"};
        String[] arr3 = {"Алиненок", "Пес", "Программисты сходят с ума чаще других людей?=)"};


        List<String[]> arrays = new ArrayList<>();
        arrays.add(arr1);
        arrays.add(arr2);
        arrays.add(arr3);

        arrays.sort((o1,o2) -> o1.length - o2.length);

        // the same with class initialization
//        arrays.sort(new Comparator<String[]>() {
//            @Override
//            public int compare(String[] o1, String[] o2) {
//                return o2.length-o1.length;
//            }
//        });



        for(String[] arr : arrays){
            System.out.println(Arrays.toString(arr));

        }
    }
}
