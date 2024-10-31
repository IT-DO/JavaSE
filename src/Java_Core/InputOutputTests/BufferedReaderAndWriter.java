package Java_Core.InputOutputTests;

import java.io.*;

public class BufferedReaderAndWriter {
    public static void main(String[] args) {
        try(BufferedReader breader = new BufferedReader(new FileReader("res/sourcefile.txt"));
            BufferedWriter bwriter = new BufferedWriter(new FileWriter("res/testfile.txt"))){
            while(breader.ready()) {
                String line = breader.readLine()+"\n";
                bwriter.write(line,0,line.length());
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
