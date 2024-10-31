package Java_Core.Collections.FinalChallenge;

import java.util.*;

public class Manager {
    private static Map<String, User> userMap = new HashMap<>();  // В мапу в качестве ключа добавляем только Immutable objects, иначе велика вероятность что будет много коллизий.

    boolean addNewUser(User user) {
        if (userMap.containsKey(user.getLogin())) {
            System.out.println("Пользователь с логином " + user.getLogin() + " уже существует");
            return false;
        } else {
            userMap.put(user.getLogin(), user);
            System.out.println(user.getLogin() + " вы успешно зарегистрировались");
            return true;
        }
    }

    boolean login(String login, String pasword) {
        if (!userMap.containsKey(login)) {
            System.out.println("Пользователя с логином " + login + " не существует");
            return false;
        } else if (userMap.get(login).getPassword().equals(pasword)) {
            System.out.println(login + " вы успешно вошли");
            return true;
        } else {
            System.out.println("Проверьте правильность введенного пароля");
            return false;
        }
    }

    boolean deleteUser(String login) {
        if (userMap.containsKey(login)) {
            userMap.remove(login);
            System.out.println("Пользователь с логином " + login + " удален.");
            return true;
        } else {
            System.out.println("Пользователь с логином " + login + " не существует");
            return false;
        }
    }

    void getAllUsers() {
        System.out.println(userMap.keySet());
    }

    void getAllUsers(String sortCriterion) {
        switch (sortCriterion) {
            case "login":
                Map<String, User> sortedByLoginMap = new TreeMap<>(userMap);
                for (Map.Entry entry : sortedByLoginMap.entrySet()) {
                    System.out.println(entry.getKey() + " " + entry.getValue());
                }
                break;
            case "date":
                UserDateComparator userDateComparator = new UserDateComparator();
                List<User> sortedByDateList = new ArrayList<>(userMap.values());
                sortedByDateList.sort(userDateComparator);
                //System.out.println(sortedByDateList);
                for(User user : sortedByDateList) {
                    System.out.println(user);
                }
                break;
        }

    }

    boolean editUser(User user){
        if(!userMap.containsKey(user.getLogin())){
            System.out.println("Пользователь с логином " + user.getLogin() + " не существует");
            return false;
        } else {
            userMap.put(user.getLogin(), user);
            System.out.println("Польхователь с логионм " + user.getLogin()+ " успешно обновлен");
            return true;
        }
    } // обновление пользователя


}
