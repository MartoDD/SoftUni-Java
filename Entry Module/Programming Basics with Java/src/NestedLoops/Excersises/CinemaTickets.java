package NestedLoops.Excersises;

import java.util.Scanner;

public class CinemaTickets {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String movie = scanner.nextLine();
        int totalCount = 0;
        int movieCount = 0;
        int kidCount = 0;
        int studentCount = 0;
        int standardCount = 0;

        while (!movie.equals("Finish")) {

            int freeSeats = Integer.parseInt(scanner.nextLine());

            String type = scanner.nextLine();
            while (!type.equals("End")) {
                totalCount++;
                movieCount++;

                switch (type) {
                    case "kid":
                        kidCount++;
                        break;
                    case "student":
                        studentCount++;
                        break;
                    case "standard":
                        standardCount++;
                        break;
                }if (movieCount==freeSeats){
                    break;
                }

                type = scanner.nextLine();
            }

            System.out.printf("%s - %.2f%% full.%n", movie, movieCount * 1.0 / freeSeats * 100);
            movieCount = 0;
            movie = scanner.nextLine();
        }
        System.out.printf("Total tickets: %d%n", totalCount);
        System.out.printf("%.2f%% student tickets.%n", studentCount * 1.0 / totalCount * 100);
        System.out.printf("%.2f%% standard tickets.%n", standardCount * 1.0 / totalCount * 100);
        System.out.printf("%.2f%% kids tickets.%n", kidCount * 1.0 / totalCount * 100);

    }
}
