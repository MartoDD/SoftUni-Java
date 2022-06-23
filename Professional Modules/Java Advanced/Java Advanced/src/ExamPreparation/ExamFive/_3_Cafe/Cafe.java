package ExamPreparation.ExamFive._3_Cafe;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cafe {

    private String name;
    private int capacity;
    private List<Employee> employees;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        if (employees.size() < capacity) {
            employees.add(employee);
        }
    }

    public boolean removeEmployee(String name) {
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                employees.remove(employee);
                return true;
            }
        }
        return false;
    }

    public Employee getOldestEmployee() {
        List<Employee>sorted =employees.stream().sorted((e1,e2)->Integer.compare(e2.getAge(),e1.getAge())).collect(Collectors.toList());
        return sorted.get(0);
    }
    public Employee getEmployee(String name){
        for (Employee employee : employees) {
            if (employee.getName().equals(name)){
                return employee;
            }
        }
        return null;
    }
    public int getCount(){
        return employees.size();
    }
    public String report(){
        StringBuilder sb = new StringBuilder();
        employees.forEach(e->sb.append("\n").append(e));
        return "Employees working at Cafe " + this.name + sb;
    }
}
