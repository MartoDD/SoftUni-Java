package FinalExam;

import java.util.Scanner;

public class Hogwarts {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StringBuilder spellToDecipher = new StringBuilder(scanner.nextLine());

        String input = scanner.nextLine();

        while (!input.equals("Abracadabra")) {
            String[] commands = input.split("\\s+");
            String spell = commands[0];
            switch (spell) {
                case "Abjuration":
                    spellToDecipher = new StringBuilder(spellToDecipher.toString().toUpperCase());
                    System.out.println(spellToDecipher);
                    break;
                case "Necromancy":
                    spellToDecipher = new StringBuilder(spellToDecipher.toString().toLowerCase());
                    System.out.println(spellToDecipher);
                    break;
                case "Illusion":
                    int index = Integer.parseInt(commands[1]);
                    String letter = commands[2];
                    if (index < 0 || index > spellToDecipher.length() - 1) {
                        System.out.println("The spell was too weak.");
                    } else {
                        spellToDecipher.replace(index, index + 1, letter);
                        System.out.println("Done!");
                    }
                    break;
                case "Divination":
                    String firstSubstring = commands[1];
                    String secondSubstring = commands[2];
                    while (spellToDecipher.toString().contains(firstSubstring)) {
                        int indexOfFirst = spellToDecipher.indexOf(firstSubstring);
                        spellToDecipher.replace(indexOfFirst, indexOfFirst + firstSubstring.length(), secondSubstring);
                    }
                    System.out.println(spellToDecipher);
                    break;
                case "Alteration":
                    String substring = commands[1];
                    if (spellToDecipher.toString().contains(substring)) {
                        int start = spellToDecipher.indexOf(substring);
                        spellToDecipher.delete(start, start + substring.length());
                        System.out.println(spellToDecipher);
                    }
                    break;
                default:
                    System.out.println("The spell did not work!");
            }


            input = scanner.nextLine();
        }
    }
}
