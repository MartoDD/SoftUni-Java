package DefiningClasses.Lab._3_BankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<Integer, BankAccount> accounts = new HashMap<>();
        while (!input.equals("End")) {

            String[] data = input.split("\\s+");
            switch (data[0]) {
                case "Create":
                    BankAccount bankAccount = new BankAccount();
                    int id = bankAccount.getId();
                    accounts.put(id, bankAccount);
                    System.out.println("Account ID" + id + " created");
                    break;
                case "Deposit":
                    int userId = Integer.parseInt(data[1]);
                    int amount = Integer.parseInt(data[2]);
                    if (accounts.containsKey(userId)) {
                        accounts.get(userId).deposit(amount);
                        System.out.println("Deposited " + amount + " to ID" + userId);
                    } else {
                        System.out.println("Account does not exist");
                    }
                    break;
                case "SetInterest":
                    double newInterest = Double.parseDouble(data[1]);
                    BankAccount.setInterestRate(newInterest);
                    break;
                case "GetInterest":
                    int account = Integer.parseInt(data[1]);
                    int years = Integer.parseInt(data[2]);
                    if (accounts.containsKey(account)) {
                        System.out.printf("%.2f%n", accounts.get(account).getInterest(years));
                    } else {
                        System.out.println("Account does not exist");
                    }
                    break;
            }

            input = scanner.nextLine();
        }
    }
}
