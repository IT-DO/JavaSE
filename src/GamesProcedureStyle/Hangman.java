package GamesProcedureStyle;
//Игра в процедурном стиле. Свои классы не создаем.

//Начало игры (Интерактивное, согласно ТЗ)
//Считываем словарь из файла
//Загадываем случайное слово
//Запускаем игровой цикл
//Получаем ввод от игрока
//Проверяем наличие введенного символа в загаданном слове
//если не угадлал, счетчик ошибок(0-6) ++ и выводим виселицу(CASE 1-6), запрашиваем ввод еще раз
//если угадал, обновляем маску слова, выводим слово на экран, запрашиваем ввод еще раз
//Проверяем количество ошибок. Если кол-во ошибок < 6
// и все символы открыты - игрок выйграл, если количество ошибок 6 игрок проиграл
// Выводим сообщение на экран

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.*;

public class Hangman {


        private static final Path path = Paths.get("res/dict.txt");             // путь к словарю в папке "res"

        private static final Scanner DICT_SCANNER;                                   // создание объекта Сканер2 для парсинга словаря

        static {
            try {
                DICT_SCANNER = new Scanner(path);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        private static final Scanner USER_SCANNER = new Scanner(System.in);            // создание объекта Сканер для ввода пользователя

        private static final Random RANDOM = new Random();                             // создание объекта Random

        private static String GAME_STATE_WIN = "Вы выиграли! Поздравляем!";

        private static String GAME_STATE_LOSE = "Вы проиграли! Допущено слишком много ошибок.";

        private  static int mistakes = 0;

    public static void main(String[] args) {
        startGameRound();
    }

    static void startGameRound() {

        List<String> dict = getDictFromFile();
        String secretWord = getRandomSecretWord(dict);
//        char [] chararray = secretWord.toCharArray();
//        System.out.println(chararray);\

        String newWord = secretWord.replaceAll("\\S", "*");
        System.out.println("Приветствую Вас в игре Виселица. Вы должны угадать слово, вводя по одной букве за шаг.");
        System.out.println("Это имя существительное, нарицательное, в именительном падеже. Разрешается 7 неправильных попыток.");
        System.out.println("После пятой неправильной попытки выдается подсказка из словаря.");
        System.out.println(secretWord);
        System.out.println(newWord);

        String userletter = getUserLetter();


    }

    static ArrayList<String> getDictFromFile() {
        ArrayList<String> array = new ArrayList<>();
        try {
            while (DICT_SCANNER.hasNext()) {
                String line = DICT_SCANNER.nextLine();
                array.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array;
    } //создаем словарь из файла и отдаем список

    static String getRandomSecretWord(List<String> list) {  // берем рандомное слово из списка ArrayList<String> list
        ArrayList<String> secretWord = new ArrayList<>();
        String randomWord = list.get(RANDOM.nextInt(list.size()));
        return randomWord;
    } // получаем random слово из словаря и отдаем массив char

    static String getUserLetter() {
        System.out.println("Введите букву с клавиатуры: ");
        String c = USER_SCANNER.next();
        return c;
    }

    static void printHangman(int mistakes) {
        String[] hangman = {
                "",
                "",
                ""
        };

        if (mistakes > 0) hangman[0] = "O";
        if (mistakes > 1) hangman[1] = " □";
        if (mistakes > 2) hangman[1] = "/□";
        if (mistakes > 3) hangman[1] = "/□\\";
        if (mistakes > 4) hangman[2] = "/";
        if (mistakes > 5) hangman[2] = "/ \\";

        String top = "_____________\n" + "|           |\n";
        String head = "|           " + hangman[0] + "\n";
        String body = "|          " + hangman[1] + "\n";
        String legs = "|          " + hangman[2] + "\n";
        String bottom = "|\n" + "‾‾‾‾‾‾‾‾‾‾‾‾‾\n";

        System.out.print("\n" + top + head + body + legs + bottom);
    }                           //вывод виселицы

}
