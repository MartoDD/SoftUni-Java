package Inheritance.Exercise._6_Animals;

public class Animal {

    protected String name;
    protected int age;
    protected String gender;

    public Animal(String name, int age, String gender) {
        setName(name);
        setAge(age);
        setGender(gender);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Invalid input!");
        }
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Invalid input!");
        }
    }

    public void setGender(String gender) {
        if (gender != null && !gender.trim().isEmpty()) {
            this.gender = gender;
        } else {
            throw new IllegalArgumentException("Invalid input!");
        }
    }

    @Override

    public String toString(){
        return String.format("%s%n%s %d %s%n%s",this.getClass().getSimpleName(),this.name,this.age,this.gender,produceSound());
    }

    public String produceSound(){
        return "";
    }
}
