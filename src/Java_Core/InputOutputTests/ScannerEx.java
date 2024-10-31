package Java_Core.InputOutputTests;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ScannerEx {
    public static void main(String[] args) {

        //запись текста из консоли в файл

        try(Scanner sc = new Scanner(System.in);
        FileWriter fw = new FileWriter("res/testfile.txt")) {
            int i = 0;
            while(i!=1) {
                char[] buffer = sc.nextLine().toCharArray();
                fw.write(buffer,0, buffer.length);
                i=1;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
