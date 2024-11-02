package Java_Core.Singleton;

public final class SimpleSingleton {

    private final static SimpleSingleton instance = new SimpleSingleton(); // final!

    private SimpleSingleton() {
    } //private!

    public static SimpleSingleton getInstance() {
        return instance;
    }

}
