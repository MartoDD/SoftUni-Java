package StreamsFilesAndDirectories.Excersize;

import java.io.*;

public class _3_AllCapitals {
    public static void main(String[] args) {

        String path = "E:\\Programki\\SoftUni\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(path));
             BufferedWriter writer = new BufferedWriter(new PrintWriter("output-All-Capitals.txt"))) {

            String line = reader.readLine();

            while (line != null) {

                writer.write(line.toUpperCase());
                writer.newLine();


                line = reader.readLine();
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
