package Java_Core.DateTime;

import java.time.Clock;
import java.time.LocalTime;

public class LocalTimeTest {
    public static void main(String[] args) {
        LocalTime time = LocalTime.now();
        System.out.println(time);

        LocalTime specificTime = LocalTime.of(2,22,21);
        System.out.println("Текущее время "+specificTime);

        LocalTime sec2000 = LocalTime.ofSecondOfDay(2000);
        System.out.println("Через 2000 секунд после 1.01.1970: "+sec2000);



    }
}
