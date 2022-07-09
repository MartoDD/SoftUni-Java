package InterfacesАndAbstraction.Lab._5_BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input= scanner.nextLine();

        List<Identifiable> idf = new ArrayList<>();

        while (!input.equals("End")){

            String[] tokens=input.split("\\s+");

            Identifiable identifiable = tokens.length==2
                    ? new Robot(tokens[0],tokens[1])
                    : new Citizen(tokens[0],Integer.parseInt(tokens[1]),tokens[2]);
            idf.add(identifiable);
            input= scanner.nextLine();
        }

        String lastDigits= scanner.nextLine();

        idf.stream().map(Identifiable::getId).filter(i->i.endsWith(lastDigits)).forEach(System.out::println);
        System.out.println();
    }
}
