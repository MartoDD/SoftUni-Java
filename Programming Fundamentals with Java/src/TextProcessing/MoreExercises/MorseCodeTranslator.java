package TextProcessing.MoreExercises;

import java.util.Scanner;

public class MorseCodeTranslator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        String [] alphabet ={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        String [] morse ={".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        StringBuilder sb = new StringBuilder();

        for (String s : input) {
            if (s.equals("|")) {
                sb.append(" ");
            } else {
                int index = 0;
                for (int j = 0; j < morse.length; j++) {
                    if (morse[j].equals(s)) {
                        index = j;
                        sb.append(alphabet[index]);
                    }
                }
            }

        }
        System.out.println(sb);
    }
}
