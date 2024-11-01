package Java_Core.Multithreading.ProducerConsumerEx;

public class Consumer implements Runnable {

    private Store store;

    public Consumer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
            store.get();
        }
    }
}
