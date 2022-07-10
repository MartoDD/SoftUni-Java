package InterfacesАndAbstraction.Exercise._3_BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Birthable> haveBirthDate = new ArrayList<>();
        while (!input.equals("End")) {

            String[] tokens = input.split("\\s+");

            switch (tokens[0]) {
                case "Citizen":
                    Birthable birthable = new Citizen(tokens[1], Integer.parseInt(tokens[2]), tokens[3], tokens[4]);
                    haveBirthDate.add(birthable);
                    break;
                case "Pet":
                    Birthable birthable1 = new Pet(tokens[1], tokens[2]);
                    haveBirthDate.add(birthable1);
                    break;
            }
            input = scanner.nextLine();
        }
        String year= scanner.nextLine();

        haveBirthDate.stream().map(Birthable::getBirthDate).filter(i->i.endsWith(year)).forEach(System.out::println);
    }
}
