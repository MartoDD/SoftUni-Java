package SetsAndMapsAdvanced.Lab;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class _2_SoftUniParty {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String invitedGuests = scanner.nextLine();

        Set<String> guests = new TreeSet<>();
        while (!invitedGuests.equals("PARTY")) {

            guests.add(invitedGuests);

            invitedGuests = scanner.nextLine();
        }

        String arrivingGuests = scanner.nextLine();

        while (!arrivingGuests.equals("END")) {
            guests.remove(arrivingGuests);

            arrivingGuests = scanner.nextLine();
        }

        System.out.println(guests.size());
        for (String guest : guests) {
            System.out.println(guest);
        }

    }
}
