package Java_Core.Singleton;
//двойная проверка для быстрой многопоточной версии
public final class DoubleCheckedLockSingleton {

    private static volatile DoubleCheckedLockSingleton instance; // volatile!

    private DoubleCheckedLockSingleton() {
    }

    public static DoubleCheckedLockSingleton getInstance() {
        if (instance == null) {
            synchronized ((DoubleCheckedLockSingleton.class)) {
                if (instance == null) {
                    instance = new DoubleCheckedLockSingleton();
                }
            }
        }
        return instance;
    }
}
