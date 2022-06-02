package StreamsFilesAndDirectories.Excersize;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class _2_SumBytes {
    public static void main(String[] args) {

        String path = "E:\\Programki\\SoftUni\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {

            String line = reader.readLine();

            long sum = 0;
            while (line != null) {
                char[] arr = line.toCharArray();
                for (char c : arr) {
                    sum += c;
                }

                line = reader.readLine();
            }
            System.out.println(sum);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
