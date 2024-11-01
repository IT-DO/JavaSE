package Java_Core.Multithreading.EventHandler;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.*;

//Создать Callable класс, метод call считает сколько секунд осталось от текущей даты
// до переданной даты и выводит на консоль каждую секунду сообщение
//System.out.println("Event: " + Thread.currentThread().getName() + "will be started in " + d.toSeconds() + " seconds");
//
//Когда указанное время наступает, то поток завершает выполнение и возвращает
//return "Event " + Thread.currentThread().getName() + "started";
//Сделать пул из 10 потоков и вызвать Разницу в секундах можно считать так:
// Duration.between(dateTime.LocalDateTime.now().toSeconds())

public class EventHandler implements Callable {

    private LocalDateTime eventDate;

    public EventHandler(LocalDateTime eventDate) {
        this.eventDate = eventDate;
    }

    @Override
    public String call() throws InterruptedException {
        long d = 0;
        while ((d = Duration.between(LocalDateTime.now(), eventDate).toSeconds()) >= 0) {
            System.out.println("Event: " + Thread.currentThread().getName() + " will be started in " + d + " seconds ");
            Thread.sleep(1000);
        }
        return "Event " + Thread.currentThread().getName() + " started";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        LocalDateTime datetime1 = LocalDateTime.now();
        Callable<String> eventHandler1 = new EventHandler(datetime1.plusSeconds(3));
        Callable<String> eventHandler2 = new EventHandler(datetime1.plusSeconds(5));
        Callable<String> eventHandler3 = new EventHandler(datetime1.plusSeconds(7));
//        Callable<String> eventHandler4 = new EventHandler(datetime1.plusSeconds(10));
//        Callable<String> eventHandler5 = new EventHandler(datetime1.plusSeconds(15));
//        Callable<String> eventHandler6 = new EventHandler(datetime1.plusSeconds(20));
//        Callable<String> eventHandler7= new EventHandler(datetime1.plusSeconds(23));
//        Callable<String> eventHandler8 = new EventHandler(datetime1.plusSeconds(25));
//        Callable<String> eventHandler9 = new EventHandler(datetime1.plusSeconds(27));
//        Callable<String> eventHandler10 = new EventHandler(datetime1.plusSeconds(30));

          Future<String> res1 = pool.submit(eventHandler1);
          Future<String> res2 = pool.submit(eventHandler2);
          Future<String> res3 = pool.submit(eventHandler3);
//        Future<String> res4 = pool.submit(eventHandler4);
//        Future<String> res5 = pool.submit(eventHandler5);
//        Future<String> res6 = pool.submit(eventHandler6);
//        Future<String> res7 = pool.submit(eventHandler7);
//        Future<String> res8 = pool.submit(eventHandler8);
//        Future<String> res9 = pool.submit(eventHandler9);
//        Future<String> res10 = pool.submit(eventHandler10);

        System.out.println(res1.get());
        System.out.println(res2.get());
        System.out.println(res3.get());
//        System.out.println(res4.get());
//        System.out.println(res5.get());
//        System.out.println(res6.get());
//        System.out.println(res7.get());
//        System.out.println(res8.get());
//        System.out.println(res9.get());
//        System.out.println(res10.get());
//        pool.shutdown();



    }

    @Override
    public String toString() {
        return "EventHandler{" +
                "eventDate=" + eventDate +
                '}';
    }


}
