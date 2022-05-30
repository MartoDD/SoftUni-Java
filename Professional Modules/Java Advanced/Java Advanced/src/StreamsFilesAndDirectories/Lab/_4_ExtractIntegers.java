package StreamsFilesAndDirectories.Lab;

import java.io.*;
import java.util.Scanner;

public class _4_ExtractIntegers {
    public static void main(String[] args) {

        String path = "E:\\Programki\\SoftUni\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            FileOutputStream fileOutputStream = new FileOutputStream("output3.txt");

            Scanner scanner =new Scanner(fileInputStream);

            PrintWriter writer =new PrintWriter(fileOutputStream);

            while (scanner.hasNext()){

                if (scanner.hasNextInt()){
                    writer.println(scanner.next());
                }else {
                    scanner.next();
                }
            }
            writer.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
