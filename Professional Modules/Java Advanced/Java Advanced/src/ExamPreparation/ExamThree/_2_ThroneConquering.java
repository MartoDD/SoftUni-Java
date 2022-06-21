package ExamPreparation.ExamThree;

import java.util.Scanner;

public class _2_ThroneConquering {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int energy = Integer.parseInt(scanner.nextLine());

        int n = Integer.parseInt(scanner.nextLine());

        char[][] sparta = new char[n][];

        int parisRow = 0;
        int parisCol = 0;

        for (int i = 0; i < n; i++) {
            String input= scanner.nextLine();
            sparta[i]=new char[input.length()];
            for (int j = 0; j < input.length(); j++) {
                sparta[i][j]=input.charAt(j);
                if (input.charAt(j)=='P'){
                    parisRow=i;
                    parisCol=j;
                }
            }
        }

        while (true) {
            boolean parisAlive=true;
            boolean escaped=false;
            String[] input = scanner.nextLine().split("\\s+");
            String direction = input[0];
            int spartanRow = Integer.parseInt(input[1]);
            int spartanCol = Integer.parseInt(input[2]);
            int futureRow=0;
            int futureCol=0;

            sparta[spartanRow][spartanCol] = 'S';

            switch (direction) {
                case "up":
                    futureRow=parisRow-1;
                    futureCol=parisCol;
                    break;
                case "down":
                    futureRow=parisRow+1;
                    futureCol=parisCol;
                    break;
                case "left":
                    futureRow=parisRow;
                    futureCol=parisCol-1;
                    break;
                case "right":
                    futureRow=parisRow;
                    futureCol=parisCol+1;
                    break;
            }

            if (isInBounds(futureRow, futureCol, sparta)) {
                if (sparta[futureRow][futureCol] == 'H') {
                    energy--;
                    sparta[parisRow][parisCol] = '-';
                    sparta[futureRow][futureCol] = '-';
                    escaped=true;
                } else if (sparta[futureRow][futureCol] == 'S') {
                    energy--;
                    energy -= 2;
                    sparta[parisRow][parisCol]='-';
                    parisRow=futureRow;
                    parisCol=futureCol;
                    sparta[parisRow][parisCol]='P';
                    if (energy <= 0) {
                        sparta[parisRow][parisCol] = 'X';
                        parisAlive=false;
                    }
                }else {
                    energy--;
                    sparta[parisRow][parisCol]='-';
                    parisRow=futureRow;
                    parisCol=futureCol;
                    sparta[parisRow][parisCol]='P';
                }
            }else {
                energy--;
            }
            if (energy<=0 && (!escaped)){
                parisAlive=false;
                sparta[parisRow][parisCol]='X';
            }

            if (escaped){
                System.out.println("Paris has successfully abducted Helen! Energy left: " + energy);
                break;
            }
            if (!parisAlive){
               System.out.println("Paris died at " + parisRow + ";" + parisCol + ".");
               break;
           }


        }
        print(sparta);
    }

    private static void print(char[][] sparta) {
        for (char[] chars : sparta) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }

    public static boolean isInBounds(int row, int col, char[][] n) {
        return row>=0 && row<n.length && col>=0 && col<n[row].length;
    }
}
