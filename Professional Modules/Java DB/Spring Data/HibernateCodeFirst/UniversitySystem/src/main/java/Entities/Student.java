package Entities;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "students")
public class Student extends Person{

    @Column(name = "average_grade")
    private double averageGrade;

    @Column
    private int attendance;

    @ManyToMany
    @JoinTable(name = "students_courses",
            joinColumns = @JoinColumn(name = "students_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "courses_id",referencedColumnName = "id"))
    private Set<Course> courses;


    public Student() {
        super();
    }


    public Student(int id, String firstName, String lastName, String phoneNumber, double averageGrade, int attendance) {
        super(id, firstName, lastName, phoneNumber);
        this.averageGrade = averageGrade;
        this.attendance = attendance;
    }


    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    public int getAttendance() {
        return attendance;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

}
