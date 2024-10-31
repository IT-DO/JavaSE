package Java_Core.InputOutputTests;

import java.io.*;
import java.util.Scanner;

public class FileIO {
    public static void main(String[] args) throws IOException {
        File dir = new File("D:/testdir");
        dir.mkdir(); // создаем директорию по адресу "d:/testdir"


        for (int i = 0; i < 10; i++) { // creating testfiles in directory "dir"
            File file = new File(dir, "testfile_" + i + ".txt");
            file.createNewFile();
        }


        for (int i = 0; i < 10; i++) {
            try (FileOutputStream fos = new FileOutputStream("D:/testdir/testfile_" + i + ".txt")) {
                fos.write(("Java " + i).getBytes());


            }
        }

        for (File f : dir.listFiles()) {
            try (FileReader fr = new FileReader(f);
                 Scanner sc = new Scanner(fr)) {
                while (sc.hasNextLine()) {
                    if (sc.nextLine().equals("Java 7")) {
                        System.out.println("Файл найден! Это файл " + f.getName());
                    }
                }
            }
        }


//        File[] paths; //Displaying files list from directory "dir" in console
//        paths = dir.listFiles();
//        for (File path : paths) {
//            System.out.println(path);
//        }
//
//        //same
//
//        for (File f : dir.listFiles()) {
//            System.out.println(f.getPath()); // вывод полного пути файла
//            System.out.println(f.getName()); // вывод только имени файла БЕЗ ПУТИ
//        }
    }


}
