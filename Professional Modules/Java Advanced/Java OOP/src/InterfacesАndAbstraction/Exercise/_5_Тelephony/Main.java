package InterfacesАndAbstraction.Exercise._5_Тelephony;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> numbers= Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        List<String> emails= Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        Smartphone smartphone = new Smartphone(numbers,emails);

        System.out.println(smartphone.call());
        System.out.println(smartphone.browse());
    }
}
