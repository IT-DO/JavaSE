package Java_Core.IO_Tests;


import java.io.*;

public class InputStreamAndOutputStream {
    public static void main(String[] args) {
        try(FileInputStream fis = new FileInputStream("res/sourcefile.txt")){
            System.out.println("File size: "+ fis.available() + " bytes");
            int i = -1;
            while((i=fis.read())!=-1){
                System.out.print((char)i);
        }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //copiing files with fis & fos and custom byte[] buffer
        try(FileInputStream fis = new FileInputStream("res/sourcefile.txt");
            FileOutputStream fos = new FileOutputStream("res/testfile.txt")){
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer,0,buffer.length);
            fos.write(buffer,0, buffer.length);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


