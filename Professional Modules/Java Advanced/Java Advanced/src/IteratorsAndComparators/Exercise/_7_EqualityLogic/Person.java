package IteratorsAndComparators.Exercise._7_EqualityLogic;

import java.util.Objects;

public class Person implements Comparable<Person>{

    private String name;
    private  int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        Person other = (Person) o;
        if (this.name.compareTo(other.name)==0){
            return Integer.compare(this.age, other.age) == 0;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public int compareTo(Person other) {
        int result=this.name.compareTo(other.name);
        if (result==0){
            result=this.age-other.age;
        }
        return result;
    }
}
