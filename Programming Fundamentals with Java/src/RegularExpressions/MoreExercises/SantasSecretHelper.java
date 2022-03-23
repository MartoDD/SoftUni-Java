package RegularExpressions.MoreExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SantasSecretHelper {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int key = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();

        List<String> goodChildren = new ArrayList<>();
        while (!input.equals("end")) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < input.length(); i++) {    //Subtracting the key from all the values, and we are rewriting the line in a stringbuilder
                char a = (char) (input.charAt(i) - key);
                sb.append(a);
            }
            Pattern pattern = Pattern.compile("@([A-Z][a-z]+)[^@\\-!:>]*!([G|N])![^@\\-!:>]*"); //one regEx to find all the values by groups
            Matcher matcher = pattern.matcher(sb);
            String name;
            String goodOrBad;

            if (matcher.find()) {                    //checking if we have a value G for Good and then if there is a found name, and then we add the names in a List of strings
                name = matcher.group(1);
                goodOrBad = matcher.group(2);
                if (goodOrBad.equals("G")) {
                    if (!name.equals("")) {
                        goodChildren.add(name);

                    }
                }
            }


            input = scanner.nextLine();
        }
        goodChildren.forEach(System.out::println);
    }
}
