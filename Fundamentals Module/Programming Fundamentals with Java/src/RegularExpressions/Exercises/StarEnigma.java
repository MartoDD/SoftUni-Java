package RegularExpressions.Exercises;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String regEx = "[STARstar]";
        List<String> attacked= new ArrayList<>();
        List<String> destroyed= new ArrayList<>();

        for (int i = 0; i < n; i++) {

            String input = scanner.nextLine();
            Pattern pattern = Pattern.compile(regEx);
            Matcher matcher = pattern.matcher(input);
            int count = 0;
            while (matcher.find()) {
                count++;
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < input.length(); j++) {
                char a = (char) (input.charAt(j) - count);
                sb.append(a);
            }
            String message = sb.toString();
            String newRegEx = "@(?<name>[A-Z][a-z]+)[^@\\-!:>]*?:(?<population>\\d+)[^@\\-!:>]*?!(?<attackType>[AD])![^@\\-!:>]*?->(?<soldierCount>\\d+)";
            Pattern messagePattern = Pattern.compile(newRegEx);
            Matcher messageMatcher = messagePattern.matcher(message);
            while (messageMatcher.find()){
                String planetName=messageMatcher.group("name");
                String type=messageMatcher.group("attackType");
                if (type.equals("A")){
                    attacked.add(planetName);
                }else if (type.equals("D")){
                    destroyed.add(planetName);
                }
            }

        }
        System.out.println("Attacked planets: " + attacked.size());
        if (attacked.size()!=0){
            attacked.stream().sorted(String::compareTo).forEach(s -> System.out.println("-> " +s));
        }
        System.out.println("Destroyed planets: " + destroyed.size());
        if (destroyed.size()!=0){
            destroyed.stream().sorted(String::compareTo).forEach(s -> System.out.println("-> " +s));
        }

    }
}
