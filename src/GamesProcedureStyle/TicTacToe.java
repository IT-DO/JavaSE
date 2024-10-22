package GamesProcedureStyle;// Игрок всегда ходит первым
// игрок всегда ставит крестикиэ
//бот всегда ставит 0
// бот выбирает случайную пустую клетку
// без ООП
// индексация рядов и колонок начинается с 0

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    private static final int ROW_COUNT = 3;                               //количество РЯДОВ игрового поля

    private static final int COL_COUNT = 3;                               //количество КОЛОНОК игрового поля

    private static final String CELL_STATE_EMPTY = " ";                   //пустое игровое поле

    private static final String CELL_STATE_X = "X";                       // игровое поле X

    private static final String CELL_STATE_O = "O";                       // игровое поле O

    private static final Scanner scanner = new Scanner(System.in);        // создание объекта Сканер

    private static final Random random = new Random();                    // создание объекта Random

    public static  String GAME_STATE_X_WON = "X победил!";                // состояние игры при котором выйграл Х

    public static  String GAME_STATE_O_WON = "O победил!";                // состояние игры при котором выйграл O

    public static  String GAME_STATE_DRAW = "Ничья =)";                   // состояние игры "Ничья"

    public static  String GAME_STATE_NOT_FINISHED = "Игра не закончена";  // состояние игры "Игра продолжается"

    public static void main(String[] args) throws NumberFormatException{
        while(true) {
            startGameRound();                                             // зациклили запуск нового раунда
        }
    }                          // main

    public static void startGameRound(){
        String[][] board = createBoard(); //создаем новую доску
        startGameLoop(board); // передаем в игровой цикл startGameLoop
    }                              // новый раунд

    public static String[][] createBoard(){         //creating game Board
        String[][] board = new String[ROW_COUNT][COL_COUNT];

        for (int row = 0; row < ROW_COUNT; row++) {
            for (int col = 0; col < COL_COUNT; col++) {
                board[row][col] = CELL_STATE_EMPTY; //инициализация пустого игрового поля
            }
        }

        return board;
    }                           // создание игрового поля

    public static void startGameLoop(String[][] board){
        boolean playerTurn = true;

        do {
            if(playerTurn) {
                makePlayerTurn(board); // ход игрока
                printBoard(board); // вывод  результатов хода игрока
            } else {


                makeBotTurn(board); //ход бота
                printBoard(board); // вывод  текущего состояния достки
            }
            playerTurn = !playerTurn;

            System.out.println();

            String gameState = checkGameState(board);
            if (!Objects.equals(gameState, GAME_STATE_NOT_FINISHED)) {
                System.out.println(gameState);
                return;
            }
        }while(true);
    }               // старт игрового цикла

    public static void makePlayerTurn(String[][] board){
        int[] coordinates = inputCellCordinates(board);
        board[coordinates[0]][coordinates[1]] = CELL_STATE_X; //place X on board
    }                       // Игрок ходит

    public static int[] inputCellCordinates(String[][] board){
        System.out.println("Введите координаты через пробел(0-2): ");

        //допущение - не проверяем на наличие пробела и корректность цифр

        do{
            String[] input = scanner.nextLine().split(" ");

            int row = Integer.parseInt(input[0]);
            int col = Integer.parseInt(input[1]);

            if(row < 0 || row >= ROW_COUNT || col < 0 || col >= COL_COUNT){
                System.out.println("Введите корректные значения через пробел от 0 до 2): ");
            }else if(!Objects.equals(board[row][col], CELL_STATE_EMPTY)) {
                System.out.println("Данная ячейка уже занята!");
            } else {
                return new int[]{row,col};
            }
            //return
        }while(true);

    }                 // метод для установки "хода" на игровое поле

    public static void makeBotTurn(String[][] board){
        System.out.println("Ход БОТА>:");
        int[] coordinates = getRandomEmptyCellCoordinates(board);
        board[coordinates[0]][coordinates[1]] = CELL_STATE_O;

    }                          // БОТ ходит

    public static int[] getRandomEmptyCellCoordinates(String[][] board){
        //get random emty cell
        do {
            int row = random.nextInt(ROW_COUNT);
            int col = random.nextInt(COL_COUNT);

            if(!Objects.equals(board[row][col], CELL_STATE_EMPTY)) {

            }else {
                return new int[]{row,col};
            }


        }while (true);
        //place O on board
    }       // Вспомогательный метода для хода БОТА

    public static String checkGameState(String[][] board){
        ArrayList<Integer> sums = new ArrayList<>();

        //iterate rows
        for (int row = 0; row < ROW_COUNT; row++) {
            int rowSum = 0;
            for (int col = 0; col < COL_COUNT; col++) {
                rowSum += calculateNumValue(board[row][col]);
            }
            sums.add(rowSum);
        }

        //iterate cols
        for (int col = 0; col < COL_COUNT; col++) {
            int colSum = 0;
            for (int row = 0; row < ROW_COUNT; row++) {
                colSum += calculateNumValue(board[row][col]);
            }
            sums.add(colSum);
        }

        //iterate diagonal from top-left to bottom-right
        int leftDiagonalSum = 0;
        for (int i = 0; i < ROW_COUNT; i++) {
            leftDiagonalSum +=calculateNumValue(board[i][i]);
        }
        sums.add(leftDiagonalSum);

        //iterate diagonal from top-right to bottom-left
        int rightDiagonalSum = 0;
        for (int i = 0; i < ROW_COUNT; i++) {
            rightDiagonalSum += calculateNumValue(board[i][(ROW_COUNT-1)-i]);
        }
        sums.add(rightDiagonalSum);


        if(sums.contains(3)){
            return GAME_STATE_X_WON;
        } else if(sums.contains(-3)){
            return GAME_STATE_O_WON;
        } else if(areAllCellsTaken(board)){
            return GAME_STATE_DRAW;
        } else {
            return GAME_STATE_NOT_FINISHED;
        }
    }                     // Проверка состояния игры

    public static int calculateNumValue(String cellState){
        if(Objects.equals(cellState, CELL_STATE_X)){
            return 1;
        } else if (Objects.equals(cellState, CELL_STATE_O)){
            return -1;
        } else {
            return 0;
        }
    }                     // Вспомогательный метод для checkGameState

    public static boolean areAllCellsTaken(String[][] board){
        for (int row = 0; row < ROW_COUNT; row++) {
            for (int col = 0; col < COL_COUNT; col++) {
                if(Objects.equals(board[row][col], CELL_STATE_EMPTY)) {
                    return false;
                }
            }
        }
        return true;
    }                  // Вспомогательный метод для проверки стейтмента "Ничья"

    public static void printBoard(String[][] board){
        System.out.println("---------");
        for (int row = 0; row < ROW_COUNT; row++) {
            String line = "| ";
            for (int col = 0; col < COL_COUNT; col++) {
                line += board[row][col] + " ";
            }
            line+= "|";

            System.out.println(line);

        }
        System.out.println("---------");
    }                           // Вывод игрового поля в консоль
}