package Java_Core.Multithreading;

public class MyOneHudredThread implements Runnable {
    private int counter;
    static int globalcounter ;
    public static void main(String[] args) {
        new Thread(new MyOneHudredThread()).start();
        new Thread(new MyOneHudredThread()).start();
        new Thread(new MyOneHudredThread()).start();


    }

    @Override
    public void run() {

        for (counter = 0; counter <= 20; counter++) {
            try {

                Thread.sleep(200);
                System.out.println(Thread.currentThread().getName() + " counter  " + counter+ " globalcounter "+ globalcounter);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            globalcounter++;
        }
    }
}


