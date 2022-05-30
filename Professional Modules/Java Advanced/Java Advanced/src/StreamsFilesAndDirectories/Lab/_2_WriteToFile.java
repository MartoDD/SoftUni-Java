package StreamsFilesAndDirectories.Lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class _2_WriteToFile {
    public static void main(String[] args) {

        String path = "E:\\Programki\\SoftUni\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            FileOutputStream fileOutputStream = new FileOutputStream("output.txt");
            int read = fileInputStream.read();

            List<Character> punctuation = new ArrayList<>();
            punctuation.add(',');
            punctuation.add('.');
            punctuation.add('!');
            punctuation.add('?');

            while (read != -1) {
                char symbol = (char) read;
                if (!punctuation.contains(symbol)) {
                    fileOutputStream.write(symbol);
                }

                read = fileInputStream.read();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
