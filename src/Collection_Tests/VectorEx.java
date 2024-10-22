package Collection_Tests;

import java.util.Vector;

public class VectorEx {
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>();
        vector.add("Anton");
        vector.add("Igor");
        vector.add("Anna");
        vector.add("Alina");
        vector.add("Mariya");
        System.out.println(vector);
        System.out.println(vector.get(0));
        System.out.println(vector.capacity());
        System.out.println(vector.lastElement());
        System.out.println(vector.remove(3));
        System.out.println(vector);
    }
}
