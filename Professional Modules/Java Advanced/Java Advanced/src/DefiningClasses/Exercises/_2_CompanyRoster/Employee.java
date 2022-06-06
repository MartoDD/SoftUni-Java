package DefiningClasses.Exercises._2_CompanyRoster;

public class Employee {

    private String name;
    private double salary;
    private String department;
    private String position;

    private String email;
    private int age;

    public Employee(String name, double salary, String department, String position) {
        this.name = name;
        this.salary = salary;
        this.department = department;
        this.position = position;
        this.email = "n/a";
        this.age = -1;
    }
    public Employee(String name, double salary, String department, String position, String email) {
       this(name,salary,department,position);
        this.email = email;
    }
    public Employee(String name, double salary, String department, String position, int age) {
        this(name,salary,department,position);
        this.age = age;
    }

    public Employee(String name, double salary, String department, String position, String email, int age) {
        this(name,salary,department,position);
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %s %d", this.name, this.salary, this.email, this.age);
    }
}
