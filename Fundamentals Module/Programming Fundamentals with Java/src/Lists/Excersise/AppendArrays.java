package Lists.Excersise;

import java.util.*;


public class AppendArrays {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] arrays = scanner.nextLine().split("\\|");
        List<String> output = new ArrayList<>();

        for (int i = arrays.length - 1; i >= 0; i--) {
            String[] miniArray = arrays[i].split("\\s+");
            output.addAll(Arrays.asList(miniArray));
        }

        for (String s : output) {
            if (!s.equals("")) {
                System.out.print(s + " ");
            }

        }


    }
}
