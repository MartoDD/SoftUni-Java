package StreamsFilesAndDirectories.Excersize;

import java.io.*;

public class _1_SumLines {
    public static void main(String[] args) {

        String path = "E:\\Programki\\SoftUni\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {

            String line = reader.readLine();

            while (line != null) {
                long sum = 0;
                char[] arr = line.toCharArray();
                for (char c : arr) {
                    sum += c;
                }
                System.out.println(sum);

                line = reader.readLine();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
