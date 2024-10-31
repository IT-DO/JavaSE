package Java_Core.IO_Tests;

import java.io.File;
import java.io.IOException;

public class IOTests {
    public static void main(String[] args) throws IOException {
        File dir = new File("d:/testdir");
        dir.mkdir(); // создаем директорию по адресу "d:/testdir"

        for (int i = 0; i < 10; i++) { // creating testfiles in directory "dir"
            File file = new File(dir, "testfile_" + i + ".txt");
            file.createNewFile();
        }

        //Displaying files list in directory "dir"
        File[] paths;
        paths = dir.listFiles();
        for (File path : paths) {
            System.out.println(path);
        }
    }


}
