package RegularExpressions.MoreExercises;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PostOffice {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> input = Arrays.stream(scanner.nextLine().split("\\|")).collect(Collectors.toList());

        String takeLetters = "(?<=([#|$|%|\\*|&]))[A-Z]+(?=(\\1))";
        String takeNumbers = "\\d+:[0-9]{2}";
        String takeWords = "[A-Z]\\w+";

        Map<Character, Integer> lettersAndLengths = new LinkedHashMap<>();

        Pattern letterPattern = Pattern.compile(takeLetters);
        Matcher letterMatcher = letterPattern.matcher(input.get(0));
        String firstPart = null;
        if (letterMatcher.find()) {                                     //we use the pattern to extract the letter combination, and then we put it in a hashmap
            firstPart = letterMatcher.group();
        }
        for (int i = 0; i < firstPart.length(); i++) {
            lettersAndLengths.putIfAbsent(firstPart.charAt(i), 0);
        }

        Pattern numberPattern = Pattern.compile(takeNumbers);
        Matcher numberMatcher = numberPattern.matcher(input.get(1));
        List<String> secondPart = new ArrayList<>();
        while (numberMatcher.find()) {                                 //we extract all number combinations and save them in a String List
            secondPart.add(numberMatcher.group());
        }
        for (String s : secondPart) {
            int[] data = Arrays.stream(s.split(":")).mapToInt(Integer::parseInt).toArray();  // we find if the ASCI code of the letter is present in the hashmap, and if it is we put the length there
            if (data[0] >= 65 && data[0] <= 90) {
                lettersAndLengths.forEach(((k, v) -> {
                    if (k == data[0]) {
                        lettersAndLengths.put(k, data[1] + 1);
                    }
                }));
            }
        }

        List<String> allWords = Arrays.stream(input.get(2).split("\\s+")).collect(Collectors.toList());   //we put all the words from the final part in a List


        lettersAndLengths.forEach((k, v) -> {                                    //we search trough the hashmap looking for words that have the same length and first letter and print them
            for (String allWord : allWords) {
                if (allWord.charAt(0) == k && allWord.length() == v) {
                    System.out.println(allWord);
                }
            }

        });


    }
}
