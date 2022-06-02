package StreamsFilesAndDirectories.Excersize;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class _4_CountCharacterTypes {
    public static void main(String[] args) {

        String path = "E:\\Programki\\SoftUni\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(path));
             BufferedWriter writer = new BufferedWriter(new PrintWriter("output-Count.txt"))) {

            List<Character> vowels = new ArrayList<>();
            vowels.add('a');
            vowels.add('e');
            vowels.add('i');
            vowels.add('o');
            vowels.add('u');
            List<Character> punctuation = new ArrayList<>();
            punctuation.add('!');
            punctuation.add(',');
            punctuation.add('.');
            punctuation.add('?');

            int c = reader.read();
            int vow = 0;
            int pun = 0;
            int consonants = 0;

            while (c >= 0) {

                char symbol = (char) c;

                if (vowels.contains(symbol)) {
                    vow++;
                } else if (punctuation.contains(symbol)) {
                    pun++;
                } else if (symbol == 32) {

                } else {
                    consonants++;
                }

                c = reader.read();
            }

            writer.write("Vowels: " + vow);
            writer.newLine();
            writer.write("Consonants: " + consonants);
            writer.newLine();
            writer.write("Punctuation: " + pun);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
