package Java_Core.Multithreading.concurrent;

public class ThreadsStartEx implements Runnable {
    private int counter;
    static int globalcounter;

    public static void main(String[] args) {
        new Thread(new ThreadsStartEx()).start();
        new Thread(new ThreadsStartEx()).start();
        new Thread(new ThreadsStartEx()).start();


    }

    @Override
    public void run() {

        for (counter = 0; counter <= 20; counter++) {
            try {

                Thread.sleep(200);
                System.out.println(Thread.currentThread().getName() + " counter  " + counter + " globalcounter " + globalcounter);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            globalcounter++;
        }
    }
}


