package ExamPreparation.ExamSix;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _1_OsPlaning {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> tasks = new ArrayDeque<>();
        ArrayDeque<Integer> threads = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(tasks::push);
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(threads::offer);

        int valueOfTask = Integer.parseInt(scanner.nextLine());

        while (tasks.size() > 0 && threads.size() > 0) {
            int task = tasks.peek();
            int thread = threads.peek();

            if (task == valueOfTask) {
                break;
            }

            if (thread >= task) {
                tasks.pop();
            }
            threads.poll();
        }
        System.out.println("Thread with value " + threads.peek() + " killed task " + tasks.peek());
        System.out.println(threads.stream().map(Object::toString).collect(Collectors.joining(" ")));


    }
}
