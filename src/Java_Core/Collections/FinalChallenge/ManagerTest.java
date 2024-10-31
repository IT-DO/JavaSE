package Java_Core.Collections.FinalChallenge;

import java.time.LocalDate;

public class ManagerTest {
    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.addNewUser(new User("AntonK", "pass123", LocalDate.of(2020, 10, 10)));                      //ok
        manager.addNewUser(new User("IgorG", "qwert123", LocalDate.of(2021, 12, 1)));                      //ok
        manager.addNewUser(new User("AnnaSh", "pas12545435", LocalDate.now()));                      //ok
        manager.addNewUser(new User("AlinaZ", "bcsisd2", LocalDate.of(2019, 4, 18)));                      //ok
        manager.addNewUser(new User("DinaN", "sedaqy21", LocalDate.of(2015, 12, 11)));                      //ok
        User usr = new User("AlinaZ", "sedddsdaqy21", LocalDate.of(2017, 12, 11));                  //ok



        System.out.println();
        manager.login("AntonK", "pass13"); // ok
        System.out.println();
        manager.login("Anton", "pass123"); // ok
        System.out.println();
        manager.login("AntonK", "pass123"); // ok

        System.out.println("Список пользователей");
        manager.getAllUsers();
        manager.deleteUser("AntonK"); // ok

        System.out.println("Новый список пользователей");
        manager.getAllUsers();

        System.out.println("Отсортированный по логину список пользователей");
        manager.getAllUsers("login");

        System.out.println("Отсортированный по ДАТЕ список пользователей");
        manager.getAllUsers("date");

        System.out.println("Обновление пользователя");
        manager.editUser(usr);



    }
}
