package StreamsFilesAndDirectories.Lab;

import java.io.*;

public class _5_WriteEveryThirdLine {
    public static void main(String[] args) {

        String path = "E:\\Programki\\SoftUni\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        try {
            BufferedReader reader=new BufferedReader(new FileReader(path));
            BufferedWriter writer = new BufferedWriter(new FileWriter("output4.txt"));

            int count=0;
            String line=reader.readLine();

            while (line!=null){
                count++;

                if (count%3==0){
                    writer.write(line);
                    writer.newLine();
                }

                line= reader.readLine();
            }
            writer.close();
            reader.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
