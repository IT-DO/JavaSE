package Java_Core.DateTime;

import java.time.*;

public class LocalDateTimeTest {
    public static void main(String[] args) {
        //Получаем текущее время
        LocalDateTime today = LocalDateTime.now();
        System.out.println("Текущее время: " + today);
        //создаем localDateTime исользуя LocalDate и LocalTime
        today = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        System.out.println("Date Time: " + today);
        //создаем LocalDateTime с указанием конкретного времени в конструкторе
        //год, месяц, день, час, минута, секунда, наносекунда...
        LocalDateTime specifiedDateTime = LocalDateTime.of(1989, 11, 22, 10, 01, 11, 100);
        System.out.println("Дата моего ДР и примерное время: " + specifiedDateTime);

        LocalDateTime dateFromBase = LocalDateTime.ofEpochSecond(2000, 0, ZoneOffset.UTC);
        System.out.println("Через 2000 сек. после 01.01.1970: " + dateFromBase);

        ZoneId zone1 = ZoneId.of("Asia/Kolkata");
        ZoneId zone2 = ZoneId.of("Asia/Tokyo");
        System.out.println(zone1);

        LocalTime time1 = LocalTime.now(zone1);
        System.out.println("India Time Zone: " + time1);

        LocalTime time2 = LocalTime.now(zone2);
        System.out.println("Japan Time Zone: " + time2);

    }
}
