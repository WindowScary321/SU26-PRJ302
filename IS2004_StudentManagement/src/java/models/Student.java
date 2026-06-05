package models;

import java.util.Date;

public class Student {
    private String id, name;
    private Date dob;
    private double grade;

    public Student() {
    }

    public Student(String id, String name, Date dob, double grade) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.grade = grade;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", dob=" + dob + ", grade=" + grade + '}';
    }
    
}
