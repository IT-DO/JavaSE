package Java_Core.Lambdas;

public class Task3 {

    public static void print(MathInterface m) {
        System.out.println(m.getMax(13, 221));
    }

    public static void main(String[] args) {
        MathInterface<Integer> m = (first, next) -> Math.max(first, next); // easypeasy
        print(m);
    }
}

@FunctionalInterface
interface MathInterface<T> {
    T getMax(T first, T next);
}