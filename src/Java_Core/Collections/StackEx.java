package Java_Core.Collections;

public class StackEx {


    static void abc1() {
        System.out.println("abc1 starts");
        System.out.println("abc1 ends");
    }

    static void abc2() {
        System.out.println("abc2 starts");
        abc1();
        System.out.println("abc2 ends");
    }

    static void abc3() {
        System.out.println("abc3 starts");
        abc2();
        System.out.println("abc3 ends");
    }

    public static void main(String[] args) {
        //LIFO - uses principle Last In First Out, можно провести аналогию со стопокй тарелок.
        System.out.println("main starts");
        abc3();
        System.out.println("main ends");
    }
}
