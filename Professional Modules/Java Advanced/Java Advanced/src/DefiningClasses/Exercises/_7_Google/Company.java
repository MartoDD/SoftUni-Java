package DefiningClasses.Exercises._7_Google;

public class Company {
    private String name;
    private String department;
    private double salary;

    public Company(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String print() {

            return String.format("%s %s %.2f",this.name,this.department,this.salary);

    }
}
