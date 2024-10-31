package Java_Core.IO_Tests;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class ReaderAndWriter {
    public static void main(String[] args) {

        //чтение текста из файла D:/Downloads/Протокол_тэк_торг.txt rjlbhjdrf Unicode UTF-8
        try(FileReader fr = new FileReader("D:/Downloads/Протокол_тэк_торг.txt")){
            int c;
            while((c=fr.read())!= -1){
                System.out.print((char) c);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        //same for 256 char
        char[] buf;
        try(FileReader fr = new FileReader("res/sourcefile.txt")){
            buf = new char[256];
            int c;
            while((c=fr.read(buf))>0){
                if(c<256){
                    buf = Arrays.copyOf(buf,c);
                }
                System.out.print(buf);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try(FileWriter fw = new FileWriter("res/testfile.txt")){
             fw.write("Тестовая запись в файл");
        }catch(IOException e ){
            e.printStackTrace();
        }

    }
}
