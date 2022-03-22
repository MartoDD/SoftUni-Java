package RegularExpressions.MoreExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WinningTicket {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> tickets = Arrays.stream(scanner.nextLine().split("[,\\s]+")).collect(Collectors.toList());
        Pattern pattern = Pattern.compile("@{6,}|\\${6,}|#{6,}|\\^{6,}");
        for (String ticket : tickets) {

            if (ticket.length() == 20) {
                String firstHalf = ticket.substring(0, 10);
                String secondHalf = ticket.substring(10);
                Matcher matcherOne = pattern.matcher(firstHalf);
                Matcher matcherTwo = pattern.matcher(secondHalf);
                if (matcherOne.find() && matcherTwo.find()) {
                    String first = matcherOne.group();
                    String second = matcherTwo.group();
                    if (first.charAt(0)==second.charAt(0)) {
                        char a = first.charAt(0);
                        if (first.length() == 10 && second.length()==10) {
                            System.out.println("ticket " + "\"" + ticket + "\"" + " - " + first.length() + String.valueOf(a) + " Jackpot!");
                        } else {
                            System.out.println("ticket " + "\"" + ticket + "\"" + " - " + Math.min(first.length(),second.length()) + String.valueOf(a));

                        }
                    } else {
                        System.out.println("ticket " + "\"" + ticket + "\"" + " - no match");
                    }
                } else {
                    System.out.println("ticket " + "\"" + ticket + "\"" + " - no match");
                }

            } else {
                System.out.println("invalid ticket");
            }

        }

    }
}
