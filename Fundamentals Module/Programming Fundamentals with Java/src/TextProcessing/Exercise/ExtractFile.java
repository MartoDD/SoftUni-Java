package TextProcessing.Exercise;

import java.util.Scanner;

public class ExtractFile {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\\\");

        String[] output = input[input.length - 1].split("\\.");

        System.out.println("File name: " + output[0]);
        System.out.println("File extension: " + output[1]);

    }
}
