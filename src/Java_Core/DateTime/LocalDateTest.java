package Java_Core.DateTime;

import java.time.LocalDate;

public class LocalDateTest {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println(today);

        LocalDate specDate  = LocalDate.of(1989,11,22);
        System.out.println("Мой др: "+specDate);

        LocalDate epochDate = LocalDate.ofEpochDay(325);
        System.out.println(epochDate);

        LocalDate myBirthday = LocalDate.ofYearDay(1989,326);
        System.out.println(myBirthday);

    }
}
