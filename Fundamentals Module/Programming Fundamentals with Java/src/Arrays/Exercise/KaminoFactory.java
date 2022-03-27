package Arrays.Exercise;

import java.util.Scanner;

public class KaminoFactory {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();

        int currentTopIndex = 99;
        int bestSum = 0;
        int bestCountDna=0;
        int countDna=0;
        int currentTopCount = 0;
        String[] bestDna = new String[length];


        while (!input.equals("Clone them!")) {
            int bestIndex = 0;
            int index = 0;
            int sum = 0;
            int bestCount = 0;
            int count = 0;
            countDna++;

            String[] dna = input.split("!+");

            for (int i = 0; i < length; i++) {
                if (dna[i].equals("1")) {
                    int number = Integer.parseInt(dna[i]);
                    sum += number;
                }
                if (dna[i].equals("1")) {
                    count++;
                    if (count > bestCount) {
                        bestCount = count;
                        bestIndex = index;
                    }
                } else {
                    count = 0;
                    index = i+1;
                }
            }
            if (bestCount > currentTopCount) {
                for (int i = 0; i < length; i++) {
                    bestDna[i] = dna[i];
                }
                bestCountDna=countDna;
                currentTopCount=bestCount;
                currentTopIndex=bestIndex;
                bestSum=sum;
            } else if (bestCount == currentTopCount) {
                if (bestIndex < currentTopIndex) {
                    for (int i = 0; i < length; i++) {
                        bestDna[i] = dna[i];
                    }
                    currentTopIndex=bestIndex;
                    bestSum=sum;
                    bestCountDna=countDna;
                } else if (bestIndex == currentTopIndex) {
                    if (sum > bestSum) {
                        for (int i = 0; i < length; i++) {
                            bestDna[i] = dna[i];
                        }
                        bestSum=sum;
                        bestCountDna=countDna;
                    }
                }
            }

            input = scanner.nextLine();
        }
        System.out.printf("Best DNA sample %d with sum: %d.%n",bestCountDna,bestSum);
        System.out.println(String.join(" ", bestDna));
    }
}
