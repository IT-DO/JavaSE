package Java_Core.DateTime;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
//способы форматирования даты и времени
public class ParsingDate {
    public static void main(String[] args) {
        LocalDateTime date1 = LocalDateTime.of(1989, 11, 22,06,00,1);
        LocalDateTime date2 = LocalDateTime.of(1982, 2, 2,10,00,1);
        LocalDateTime date3 = LocalDateTime.now();
        Instant timestamp = Instant.now();

        System.out.println(date1.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));

        System.out.println(date3.format(DateTimeFormatter.ISO_DATE));

        System.out.println(timestamp);

        System.out.println(date2.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))); // формат даты  dd.MM.yyyy

        System.out.println(date1.minusYears(date2.getYear()).getYear()); //Разница между датами в годах

        System.out.println(Duration.between(date1,date2).toDays()*-1); // разница между датами в днях
    }
}
