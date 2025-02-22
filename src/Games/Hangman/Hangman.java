package Games.Hangman;
//Игра в процедурном стиле. Свои классы не создаем.
//Начало игры (Интерактивное, согласно ТЗ)
//Считываем словарь из файла
//Загадываем случайное слово
//Запускаем игровой цикл
//Получаем ввод от игрока
//Проверяем наличие введенного символа в загаданном слове
//если не угадлал, счетчик ошибок(0-6) ++ и выводим виселицу(CASE 1-6), запрашиваем ввод еще раз
//если угадал, обновляем маску слова, выводим слово на экран, запрашиваем ввод еще раз
//Проверяем количество ошибок. Если кол-во ошибок > 0
// и все символы открыты - игрок выйграл, если количество оставшихся ошибок 0  - игрок проиграл
// Выводим сообщение на экран и виселицу The End

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;

public class Hangman {
    // путь к словарю в папке "res" СЛОВА от 4 до 8 символов - русские существительные в именительном падеже (единственное число, мужской и женский род)
    private static final Path path = Paths.get("res/dict.txt");

    // создание объекта Сканер для ввода пользователя
    private static final Scanner USER_SCANNER = new Scanner(System.in);

    // создание объекта Random для выбора случайного слова из словаря
    private static final Random RANDOM = new Random();

    private static final String MAIN_MENU_QUESTION = "Хотите сыграть в игру \"Виселица\" . . . ?\nДля начала игры введите: 1 + Enter\nДля выхода из игры введите: 0 + Enter";

    private static final String GREETING_AND_RULES = "Приветствуем Вас в игре Виселица. Цель игры: угадать слово, вводя по одной букве за шаг.\nЭто слово - имя существительное длиной от 4 до 8 букв, в именительном падеже мужского или женского рода. Допускается не более 6 ошибок.\n";

    private static final String GAME_STATE_WIN = "Вы выиграли! Поздравляем!";

    private static final String GAME_STATE_LOSE = "Вы проиграли! Допущено слишком много ошибок.";

    private static final String GAME_STATE_NOT_FINISHED = "Игра не окончена";

    private static int mistakes = 6;

    private static String secretWord;

    private static String maskWord;

    private static Set<Character> userLetterSet;

    //точка входа в приложение
    public static void main(String[] args) {
        menu();
    }

    //пользовательское меню
    static void menu() {
        printHangman(mistakes);
        System.out.println(MAIN_MENU_QUESTION);
        char input = getUserInput();
        if (input == '1') {
            System.out.println(GREETING_AND_RULES);
            roundInitialize();
            startGameLoop();
        } else if (input == '0') {
            System.out.println("Мы будем скучать ... =(");
            USER_SCANNER.close();
            System.exit(1);
        } else {
            System.out.println("Вы ввели что-то не то, попробуйте еще раз...");
            menu();
        }
    }

    //вывод виселицы в консоль
    static void printHangman(int mistakes) {
        String[] hangman = {"", "", ""};

        if (mistakes < 5) hangman[0] = "O";
        if (mistakes < 4) hangman[1] = " □";
        if (mistakes < 3) hangman[1] = "/□";
        if (mistakes < 2) hangman[1] = "/□\\";
        if (mistakes < 1) hangman[2] = "/";
        if (mistakes <= 0) hangman[2] = "/ \\" + "\n        GAME_OVER";

        String top = """
                _____________
                |           |
                """;
        String head = "|           " + hangman[0] + "\n";
        String body = "|          " + hangman[1] + "\n";
        String legs = "|          " + hangman[2] + "\n";
        String bottom = """
                |
                ‾‾‾‾‾‾‾‾‾‾‾‾‾
                """;
        System.out.print("\n" + top + head + body + legs + bottom);
    }

    //получаем ввод от пользователя
    static char getUserInput() {
        char c = USER_SCANNER.next().charAt(0);
        if (inputValidation(c)) {
            return c;
        } else {
            System.out.println("Проверьте язык ввода, у нас только русские слова! ;)");
            return getUserInput();
        }
    }

    //запускаем раунд
    static void roundInitialize() {
        List<String> dict = createDictionary();                                                                         //создаем словарь из файла в папке res/dict.txt
        secretWord = getRandomSecretWord(dict);                                                                         //получаем рандомное слово из словаря
        maskWord = secretWord.replaceAll("\\S", "*");                                                   //маскируем полученное слово "*" звездочками
        userLetterSet = new HashSet<>();                                                                                //создаем коллекцию введенных пользователем символов
        System.out.println(maskWord.toUpperCase());                                                                                   //показываем слово пользователю
    }

    //начало игрового цикла
    static void startGameLoop() {
        boolean isExit = false;
        while (!isExit) {
            System.out.println("Введите предполагаемую букву и нажмите Enter.                                                          Подсказка: Если хотите начать новый раунд, введите 0 + Enter");
            char userInput = getUserInput();
            userLetterSet.add(userInput);

            if (userInput == '0') {
                isExit = true;
                roundInitialize();
                startGameLoop();
            } else if (secretWord.contains(String.valueOf(userInput))) {
                System.out.println("\nЕсть такая буква!");
                maskWord = openLetterInMask(userInput);
            } else {
                System.out.println("Мимо! Попробуйте еще...");
                mistakes--;
            }

            printHangman(mistakes);

            printCurrentTurnInfo(mistakes);

            String gameState = checkGameState(mistakes);

            if (!Objects.equals(gameState, GAME_STATE_NOT_FINISHED)) {
                System.out.println(gameState);
                mistakes = 6;
                menu();
            }

        }

    }

    //создаем словарь из файла и отдаем список слов
    static ArrayList<String> createDictionary() {
        ArrayList<String> array = new ArrayList<>();
        Scanner DICT_SCANNER;
        try {
            DICT_SCANNER = new Scanner(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            while (DICT_SCANNER.hasNext()) {
                String line = DICT_SCANNER.nextLine();
                array.add(line);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return array;
    }

    //выбираем рандомное слово из нашего словаря
    static String getRandomSecretWord(List<String> list) {
        return list.get(RANDOM.nextInt(list.size()));
    }

    //валидация ввода
    public static boolean inputValidation(char userInput) {
        String regex = "[а-яА-ЯёЁ0-1]";
        return Pattern.matches(regex, String.valueOf(userInput));
    }

    //открываем отгаданную букву в замаскированном слове
    private static String openLetterInMask(char userInput) {
        char[] maskArray = maskWord.toCharArray();
        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) == userInput) {
                maskArray[i] = userInput;
            }
        }
        return String.valueOf(maskArray);
    }

    //вывод информации о текущем ХОДЕ
    private static void printCurrentTurnInfo(int mistakes) {
        System.out.println("Загаданное слово: " + maskWord.toUpperCase() + "\nКоличество оставшихся попыток: "
                + mistakes + "\nБуквы, которые вы уже ввели: " + userLetterSet.toString().toUpperCase() + "\n");
    }

    //проверяем статус игры
    private static String checkGameState(int mistakes) {
        if (mistakes == 0) {
            return GAME_STATE_LOSE + "\n" + "Загаданное слово: " + secretWord.toUpperCase();
        } else if (secretWord.equals(maskWord)) {
            return GAME_STATE_WIN;
        } else {
            return GAME_STATE_NOT_FINISHED;
        }
    }

}
