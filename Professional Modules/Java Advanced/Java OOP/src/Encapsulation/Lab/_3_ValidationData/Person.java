package Encapsulation.Lab._3_ValidationData;

import java.text.DecimalFormat;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setSalary(salary);
    }

    public void setSalary(double salary) {
        if (salary>=460){
            this.salary = salary;
        }else {
            throw new IllegalArgumentException("Salary cannot be less than 460 leva");
        }
    }

    public void setFirstName(String firstName) {
        if (firstName.length()>=3){
            this.firstName = firstName;
        }else {
            throw new IllegalArgumentException("First name cannot be less than 3 symbols");
        }
    }

    public void setLastName(String lastName) {
        if (lastName.length()>=3){
            this.lastName = lastName;
        }else {
            throw new IllegalArgumentException("Last name cannot be less than 3 symbols");
        }

    }

    public void setAge(int age) {
        if (age>0){
            this.age = age;
        }else {
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        }
    }

    public double getSalary() {
        return salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public void increaseSalary(double bonus) {
        if (age < 30) {
            salary = salary + salary * bonus / 200;
        } else {
            salary = salary + salary * bonus / 100;
        }
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.0##");
        return this.firstName + " " + this.lastName + " gets " +df.format(this.salary) + " leva";


    }
}
