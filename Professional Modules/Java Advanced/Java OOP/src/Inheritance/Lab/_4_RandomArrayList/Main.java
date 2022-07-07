package Inheritance.Lab._4_RandomArrayList;

public class Main {
    public static void main(String[] args) {

        RandomArrayList rAl= new RandomArrayList();

        rAl.add(123);
        rAl.add(143);
        rAl.add(323);
        rAl.add(63);
        rAl.add(13);

        System.out.println(rAl.getRandomElement());
    }
}
