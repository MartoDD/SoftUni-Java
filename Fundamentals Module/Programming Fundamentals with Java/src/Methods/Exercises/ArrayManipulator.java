package Methods.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayManipulator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        String input = scanner.nextLine();

        while (!input.equals("end")) {

            String[] command = input.split("\\s+");

            switch (command[0]) {
                case "exchange":
                    int info = Integer.parseInt(command[1]);
                    exchange(array, info);
                    break;
                case "max":
                    if (command[1].equals("even")) {
                        printMaxEvenNumber(array);

                    } else if (command[1].equals("odd")) {

                        printMaxOddNumber(array);
                    }
                    break;
                case "min":
                    if (command[1].equals("even")) {
                        printMinEvenNumber(array);

                    } else if (command[1].equals("odd")) {

                        printMinOddNumber(array);
                    }
                    break;

                case "first":
                    int value = Integer.parseInt(command[1]);
                    if (value> array.length || value<0){
                        System.out.println("Invalid count");
                        break;
                    }
                    int count = 0;

                    if (command[2].equals("even")) {
                        printFirstEvenNumber(array, value, count);
                    } else if (command[2].equals("odd")) {
                        printFirstOddNumber(array, value, count);
                    }
                    break;
                case "last":
                    int vl = Integer.parseInt(command[1]);
                    if (vl> array.length || vl<0){
                        System.out.println("Invalid count");
                        break;
                    }
                    int ct =0;
                    StringBuilder even= new StringBuilder();
                    StringBuilder odd= new StringBuilder();
                    if (command[2].equals("even")) {
                        printLastEvenNumber(array, vl, ct, even);
                    }else if (command[2].equals("odd")){
                        printLastOddNumber(array, vl, ct, odd);
                    }

                    break;
            }

            input = scanner.nextLine();

        }
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            int a = array[i];
            System.out.print(a);
            if (i!=array.length-1){
                System.out.print(", ");
            }
        }
        System.out.print("]");
        System.out.println();

    }

    private static void printLastOddNumber(int[] array, int vl, int ct, StringBuilder odd) {
        System.out.print("[");
        for (int i = array.length-1; i>=0; i--) {
            int j = array[i];
            if (j % 2 != 0) {
                if (ct >= vl) {
                    break;
                }
                ct++;
                odd.append(j).append(" ");
            }
        }
        String[] numbers=odd.toString().split(" ");
        for (int i = numbers.length-1; i >=0 ; i--) {
            if (i==0){
                System.out.print(numbers[i]);
            }else {
                System.out.print(numbers[i] + ", ");
            }

        }
        System.out.print("]");
        System.out.println();
    }

    private static void printLastEvenNumber(int[] array, int vl, int ct, StringBuilder even) {
        System.out.print("[");
        for (int i = array.length-1; i>=0; i--) {
            int j = array[i];
            if (j % 2 == 0) {
                if (ct >= vl) {
                    break;
                }
                ct++;
                even.append(j).append(" ");
            }
        }
        String[] numbers=even.toString().split(" ");
        for (int i = numbers.length-1; i >=0 ; i--) {
            if (i==0){
                System.out.print(numbers[i]);
            }else {
                System.out.print(numbers[i] + ", ");
            }

        }
        System.out.print("]");
        System.out.println();
    }

    private static void printFirstOddNumber(int[] array, int value, int count) {
        System.out.print("[");
        for (int j : array) {
            if (j % 2 != 0) {
                if (count >= value) {
                    break;
                }
                count++;
                if (count==1){
                    System.out.print(j);
                }else {
                    System.out.print(", " + j);
                }

            }
        }
        System.out.print("]");
        System.out.println();
    }

    private static void printFirstEvenNumber(int[] array, int value, int count) {
        System.out.print("[");
        for (int j : array) {
            if (j % 2 == 0) {
                if (count >= value) {
                    break;
                }
                count++;
                if (count == 1) {
                    System.out.print(j);
                } else {
                    System.out.print(", " + j);
                }

            }
        }
        System.out.print("]");
        System.out.println();
    }

    private static void printMinOddNumber(int[] array) {
        int minOdd = Integer.MAX_VALUE;
        int minOddIndex = 0;
        boolean hasOdd = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                hasOdd = true;
                if (array[i] <= minOdd) {
                    minOdd = array[i];
                    minOddIndex = i;
                }
            }
        }
        if (hasOdd) {
            System.out.println(minOddIndex);
        } else {
            System.out.println("No matches");
        }

    }

    private static void printMinEvenNumber(int[] array) {
        int minEven = Integer.MAX_VALUE;
        int minEvenIndex = 0;
        boolean hasEven = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                hasEven = true;
                if (array[i] <= minEven) {
                    minEven = array[i];
                    minEvenIndex = i;
                }
            }
        }
        if (hasEven) {
            System.out.println(minEvenIndex);
        } else {
            System.out.println("No matches");
        }

    }

    private static void printMaxOddNumber(int[] array) {
        int maxOdd = 0;
        int maxOddIndex = 0;
        boolean hasOdd = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                hasOdd = true;
                if (array[i] >= maxOdd) {
                    maxOdd = array[i];
                    maxOddIndex = i;
                }
            }
        }
        if (hasOdd) {
            System.out.println(maxOddIndex);
        } else {
            System.out.println("No matches");
        }

    }

    private static void printMaxEvenNumber(int[] array) {
        int maxEven = 0;
        int maxEvenIndex = 0;
        boolean hasEven = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                hasEven = true;
                if (array[i] >= maxEven) {
                    maxEven = array[i];
                    maxEvenIndex = i;
                }
            }
        }
        if (hasEven) {
            System.out.println(maxEvenIndex);
        } else {
            System.out.println("No matches");
        }

    }

    private static void exchange(int[] array, int info) {
        if (info >= array.length || info<0) {
            System.out.println("Invalid index");
        } else {
            int[] first = new int[info + 1];
            int[] second = new int[array.length - (info + 1)];

            System.arraycopy(array, 0, first, 0, first.length);
            int c = 0;
            for (int i = first.length; i < array.length; i++) {
                second[c] = array[i];
                c++;
            }
            System.arraycopy(second, 0, array, 0, second.length);
            int b = 0;
            for (int i = second.length; i < array.length; i++) {
                array[i] = first[b];
                b++;
            }
        }
    }
}
