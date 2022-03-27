package MapsLambdaAndStreamAPI.Lab;

import java.util.*;

public class WordSynonyms {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, List<String>> synonyms = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String word = scanner.nextLine();
            String synonym = scanner.nextLine();

            synonyms.putIfAbsent(word, new ArrayList<>());
            synonyms.get(word).add(synonym);
        }
        for (Map.Entry<String, List<String>> s : synonyms.entrySet()) {
            System.out.printf("%s - ", s.getKey());
            int i = 0;
            for (String s1 : s.getValue()) {
                if (i != s.getValue().size() - 1) {
                    System.out.print(s1 + ", ");
                } else {
                    System.out.println(s1);
                }
                i++;
            }


        }

    }
}
