package Java_Core.Lambdas;

public class Task1 {
    public static void main(String[] args) {
        Thread thread = new Thread(
                ()-> System.out.println("Hello world!")
        );
        thread.start();
    }
}
