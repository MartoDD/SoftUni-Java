package Generics.Exercise._11_Threeuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Threeuple> list=new ArrayList<>();

        String[] input= scanner.nextLine().split("\\s+");
        String name= input[0] + " " + input[1];
        String address = input[2];
        String town = input[3];

        Threeuple<String,String,String> threeuple1=new Threeuple<>(name,address,town);
        list.add(threeuple1);

        input=scanner.nextLine().split("\\s");
        name=input[0];
        int beer =Integer.parseInt(input[1]);
        boolean drunkOrNOt=input[2].equals("drunk");

        Threeuple<String,Integer,Boolean> threeuple2 = new Threeuple<>(name,beer,drunkOrNOt);
        list.add(threeuple2);
        input=scanner.nextLine().split("\\s");

        name=input[0];
        double accountBalance=Double.parseDouble(input[1]);
        String bankName=input[2];

        Threeuple<String,Double,String> threeuple3 = new Threeuple<>(name,accountBalance,bankName);
        list.add(threeuple3);

        list.forEach(System.out::println);

    }
}
