package Java_Core.Multithreading;

//boost up your PERFORMANCE!
public class ThreadsRunnableEx1 implements Runnable {
    String localname;

    public ThreadsRunnableEx1(String localname) {
        this.localname = localname;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is started");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new ThreadsRunnableEx1("1"));
        Thread thread2 = new Thread(new ThreadsRunnableEx1("2"));
        Thread thread3 = new Thread(new ThreadsRunnableEx1("3"));
        Thread thread4 = new Thread(new ThreadsRunnableEx1("4"));
        Thread thread5 = new Thread(new ThreadsRunnableEx1("5"));
        Thread thread6 = new Thread(new ThreadsRunnableEx1("6"));

        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(Thread.MIN_PRIORITY);
        thread3.setPriority(2);
        boolean alive = thread3.isAlive();
        System.out.println(alive);

        thread1.start();

        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        alive = thread3.isAlive();
        System.out.println(alive);
    }
}
