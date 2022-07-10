package InterfacesАndAbstraction.Exercise._4_FoodShortage;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String,Buyer> people=new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String [] input= scanner.nextLine().split("\\s+");

            Buyer buyer;
            if (input.length==3){

                buyer = new Rebel(input[0], Integer.parseInt(input[1]), input[2]);
            }else {
                buyer = new Citizen(input[0], Integer.parseInt(input[1]), input[2], input[3]);
            }
            people.put(input[0],buyer);
        }

        String input= scanner.nextLine();

        while (!input.equals("End")){

            if (people.containsKey(input)){
                people.get(input).buyFood();
            }

            input= scanner.nextLine();
        }
        System.out.println(people.values().stream().mapToInt(Buyer::getFood).sum());
    }
}
