package MultidimensionalArrays.Exercises;

import java.util.Scanner;

public class _1_FillTheMatrix {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int value=Integer.parseInt(input[0]);
        switch (input[1]) {
            case "A":
                printMatrixA(value);
                break;
            case "B":
                printMatrixB(value);
                break;
        }


    }

    private static void printMatrixB(int value) {

        int[][] matrix=new int[value][value];
        for (int row = 0; row < value; row++) {
            int number=row+1;
            int previousNumber=0;
            for (int col = 0; col < value; col++) {
                if (col%2==0){
                    matrix[row][col]=number+previousNumber;
                }else {

                }
                previousNumber=matrix[row][col];
            }
        }
    }

    private static void printMatrixA(int value) {

        int[][] matrix=new int[value][value];
        for (int row = 0; row < value; row++) {
            int number=row+1;
            for (int col = 0; col < value; col++) {
                matrix[row][col]=number;
                number+=value;
            }

        }
        for (int[] row : matrix) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();

        }

    }
}
