package StacksAndQueues.Exercises;

import java.util.*;

public class Robotics {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(";");
        List<Robot> robots = new ArrayList<>();

        for (String s : input) {
            String[] parameters = s.split("-");
            Robot robot = new Robot(parameters[0], Integer.parseInt(parameters[1]), 0);  //записвам роботите в един списък от обекти
            robots.add(robot);
        }

        String startTime = scanner.nextLine();
        int timerAsNumber = getTimeAsNumber(startTime); //използвам метод за обръщане на въведеното време в секунди

        String product = scanner.nextLine();
        ArrayDeque<String> productQueue = new ArrayDeque<>();
        while (!product.equals("End")) {                //записвам всички продукти в опашка
            productQueue.offer(product);
            product = scanner.nextLine();
        }

        while (!productQueue.isEmpty()) {                  //пускам цикъл докато опашката не е празна

            timerAsNumber++;                               //за всеки цикъл увеличавам с 1 секунда
            boolean hasFree = false;
            for (Robot robot : robots) {                     //итерирам през списъка с роботи и проверявам дали има свободни (ако е намерало вече свободен, не влиза отново). Всеки робот има таймер в класът си
                boolean b = robot.getTimer() == robot.getTimeToProcess(); //като проверявам дали има таймер, който е на 0 или има таймер който е равна стойност като времето необходимо на робота да обработи продукта
                if (!hasFree && (b || robot.getTimer() == 0)) {
                    System.out.println(robot.getName() + " - " + productQueue.poll() + currentTime(timerAsNumber)); //тук принтирам, чрез метод настоящото време като обърщам от секунди във формата за принтиране
                    robot.setTimer(1);
                    hasFree = true;
                } else {                                    //за всеки робот, който не е свободен, увеличавам таймера с едно
                    if (robot.getTimer() != 0) {
                        robot.setTimer(robot.getTimer() + 1);
                    }
                }
            }
            if (!hasFree) {                                 //ако след цялата итерация не е намерило нито един свободен робот, слагам продукта на края на опашката и почва нов цикъл
                productQueue.offer(productQueue.poll());
            }
        }
    }

    private static String currentTime(int timerAsNumber) {

        long seconds=timerAsNumber%60;
        long minutes=(timerAsNumber/60)%60;
        long h =(timerAsNumber/(60*60))%24;


        return String.format(" [%02d:%02d:%02d]",h,minutes,seconds);
    }

    private static int getTimeAsNumber(String startTime) {
        int sum;

        int[] parts = Arrays.stream(startTime.split(":")).mapToInt(Integer::parseInt).toArray();
        int hours = parts[0] * 60 * 60;
        int minutes = parts[1] * 60;
        int seconds = parts[2];
        sum = hours + minutes + seconds;

        return sum;
    }

    public static class Robot {
        String name;
        int timeToProcess;
        int timer;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getTimeToProcess() {
            return timeToProcess;
        }

        public void setTimeToProcess(int timeToProcess) {
            this.timeToProcess = timeToProcess;
        }

        public int getTimer() {
            return timer;
        }

        public void setTimer(int timer) {
            this.timer = timer;
        }

        public Robot(String name, int timeToProcess, int timer) {
            this.name = name;
            this.timeToProcess = timeToProcess;
            this.timer = timer;
        }
    }
}
