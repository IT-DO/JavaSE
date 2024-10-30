package Java_Core.Collections;

import java.util.*;

public class MemoryTesting {
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>(100);
        int capacity = random.nextInt(500);
        for (int i = 0; i <= capacity; i++) {
            list.add(random.nextInt(21));
            for (int j = 0; j < capacity; j++) {
                list.add(random.nextInt(20));
            }
        }

        Set<Integer> set = new TreeSet<>(list);

        String maxMemory = ("Max. memory: " + Runtime.getRuntime().maxMemory() / 1000 + " Kb");
        String usedMemory = ("Used memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1000 + " Kb");
        String freeMemory = ("Free memory: " + Runtime.getRuntime().freeMemory() / 1000 + " Kb");
        String totalMemory = ("Total memory: " + Runtime.getRuntime().totalMemory() / 1000 + " Kb");
        System.out.println(list);
        System.out.println("\nРазмер списка " + list.size());

        System.out.println(set);
        System.out.println("Размер TreeSet: "+ set.size());
        System.out.println();
        System.out.println(totalMemory);
        System.out.println(usedMemory);
        System.out.println(freeMemory);
        System.out.println();
        System.out.println(maxMemory);


    }
}
