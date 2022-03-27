package Lists.Excersise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SoftUniCoursePlanning {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("course start")) {

            String[] commands = input.split(":");
            switch (commands[0]) {
                case "Add":
                    String lessonTitle = commands[1]; //Проверяваме дали урока присъства и ако го няма го добавяме накрая
                    if (!names.contains(lessonTitle)) {
                        names.add(lessonTitle);
                    }
                    break;
                case "Insert":
                    String title = commands[1];    //Проверяваме дали урока присъства и ако го няма го добавяме на съответния индекс
                    int index = Integer.parseInt(commands[2]);
                    if (!names.contains(title)) {
                        names.add(index, title);
                    }
                    break;
                case "Remove":
                    String titl = commands[1]; //Премахваме заглавието ако го има
                    names.remove(titl);
                    break;
                case "Swap":
                    String lessonOne = commands[1];
                    String lessonTwo = commands[2];
                    int indexLessonOne = 0;
                    int indexLessonTwo = 0;

                    if (names.contains(lessonTwo) && names.contains(lessonOne)) { //проверка дали заглавията на уроците присъстват преди да премина към разменяне
                        for (int i = 0; i < names.size(); i++) {  //фор цикъл за да установя индекса на първия урок
                            if (names.get(i).equals(lessonOne)) {
                                indexLessonOne = i;
                            }
                        }
                        for (int i = 0; i < names.size(); i++) { //фор цикъл за да установя индекса на втория урок
                            if (names.get(i).equals(lessonTwo)) {
                                indexLessonTwo = i;
                            }
                        }
                        String toCheckOne = lessonOne + "-Exercise"; // създавам име за упражнението
                        if (names.contains(toCheckOne)) {    // проверявам дали вече има въведено упражнение като по-горе го създавам като String
                            names.set(indexLessonTwo, lessonOne);  //правя размяната на уроците
                            names.remove(toCheckOne);                       //ако упражнението го  има махам съществуващото
                            names.add(indexLessonTwo + 1, toCheckOne);//и го слагам на индекса на урока+1

                        } else {
                            names.set(indexLessonTwo, lessonOne); //ако упражнението го няма просто сменям уроците
                        }
                        String toCheckTwo = lessonTwo + "-Exercise";  // тук правя аналогична операция за името на втория урок
                        if (names.contains(toCheckTwo)) {
                            names.set(indexLessonOne, lessonTwo);
                            names.remove(toCheckTwo);
                            names.add(indexLessonOne + 1, toCheckTwo);

                        } else {
                            names.set(indexLessonOne, lessonTwo);
                        }
                    }
                    break;
                case "Exercise":
                    String exercise = commands[1];
                    String toAdd = exercise + "-Exercise";
                    if (!names.contains(exercise)) {  //проверявам дали името на урока присъства, ако не, го добавям накрая и после добавям променливата toAdd, която е комбинация от името на урока пюс -Exercise
                        names.add(exercise);
                        names.add(toAdd);
                    } else {
                        if (!names.contains(toAdd)) {
                            for (int i = 0; i < names.size(); i++) { //ако урока го има, пускам фор цикъл и при съвпадение добавам името на урока на позиция index+1 от съвпадението
                                if (names.get(i).equals(exercise)) {
                                    names.add(i + 1, toAdd);
                                }
                            }
                        }
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        for (int i = 0; i < names.size(); i++) {
            System.out.printf("%d.%s%n", i + 1, names.get(i));
        }
    }
}
