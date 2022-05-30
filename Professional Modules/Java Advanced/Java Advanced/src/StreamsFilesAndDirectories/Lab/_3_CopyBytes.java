package StreamsFilesAndDirectories.Lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class _3_CopyBytes {
    public static void main(String[] args) {

        String path = "E:\\Programki\\SoftUni\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            FileOutputStream fileOutputStream = new FileOutputStream("output2.txt");
            PrintWriter writer = new PrintWriter(fileOutputStream);
            int read = fileInputStream.read();


            while (read != -1) {

                char symbol = (char) read;

                if (symbol==' '){
                    writer.print(' ');
                }else if (symbol==10){
                    writer.println();
                }else {
                    writer.print(read);
                }
                read=fileInputStream.read();
            }
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
