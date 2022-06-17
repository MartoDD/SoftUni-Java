package IteratorsAndComparators.Exercise._5_ComparingObjects;

public class Person implements Comparable<Person> {
    String name;
    int age;
    String town;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    @Override
    public int compareTo(Person other) {
        if (this.name.equals(other.name)){
            if (this.age==other.age){
                return this.town.compareTo(other.town);
            }else {
                return Integer.compare(this.age,other.age);
            }
        }else {
            return this.name.compareTo(other.name);
        }
    }
}
