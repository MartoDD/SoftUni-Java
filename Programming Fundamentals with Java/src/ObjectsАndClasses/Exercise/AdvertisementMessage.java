package ObjectsАndClasses.Exercise;

import java.util.*;

public class AdvertisementMessage {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<String> phrases = Arrays.asList("Excellent product.", "Such a great product.", "I always use that product.", "Best product of its category.", "Exceptional product.", "I can’t live without this product.");
        List<String> events = Arrays.asList("Now I feel good.", "I have succeeded with this product.", "Makes miracles. I am happy of the results!", "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!");
        List<String> authors = Arrays.asList("Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva");
        List<String> cities = Arrays.asList("Burgas", "Sofia", "Plovdiv", "Varna", "Ruse");

        Random rnd = new Random();
        for (int i = 0; i < n; i++) {
            randomPhrase(phrases, rnd);
            randomPhrase(events, rnd);
            randomPhrase(authors, rnd);
            randomPhrase(cities, rnd);
            System.out.println();
        }
    }

    private static void randomPhrase(List<String> phrases, Random rnd) {
        int number = rnd.nextInt(phrases.size());
        System.out.print(phrases.get(number) + "  ");
    }
}
