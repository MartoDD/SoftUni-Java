package ExamPreparation.ExamTwo;

import java.util.*;
import java.util.stream.Collectors;

public class _1_FoodFinder {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> vowels = new ArrayDeque<>();
        ArrayDeque<String> consonants = new ArrayDeque<>();


        List<String> vowelsList = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        List<String> consonantList = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        vowelsList.forEach(vowels::offer);
        consonantList.forEach(consonants::push);

        String[] words = {"pear", "flour", "pork", "olive"};
        String[] wordsFound = {"****", "*****", "****", "*****"};

        while (consonants.size() > 0) {
            String vowel = vowels.poll();
            String consonant = consonants.pop();

            for (int i = 0; i < words.length; i++) {
                int indexVowel;
                if (words[i].contains(vowel)) {
                    indexVowel = words[i].indexOf(vowel);
                    StringBuilder sb = new StringBuilder(wordsFound[i]);
                    sb.setCharAt(indexVowel, vowel.charAt(0));
                    wordsFound[i] = sb.toString();
                }
                int indexConsonant;
                if (words[i].contains(consonant)) {
                    indexConsonant = words[i].indexOf(consonant);
                    StringBuilder sb = new StringBuilder(wordsFound[i]);
                    sb.setCharAt(indexConsonant, consonant.charAt(0));
                    wordsFound[i] = sb.toString();
                }

            }


            vowels.offer(vowel);
        }
        List<String> test = Arrays.stream(words).collect(Collectors.toList());
        List<String> forOutput = new ArrayList<>();
        for (String s : wordsFound) {
            if (test.contains(s)) {
                forOutput.add(s);
            }
        }
        System.out.println("Words found: " + forOutput.size());
        forOutput.forEach(System.out::println);

    }
}
