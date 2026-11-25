package com.hristo.sandbox.entity;

import jakarta.persistence.*;

import java.text.DecimalFormat;

@Entity
@Table(name="teachers")
public class Teacher {

    // fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="teacher_id")
    private int teacherId;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

    @Column(name="age")
    private int age;

    @Column(name="main_subject")
    private String mainSubject;

    @Column(name="salary")
    private double salary;

    // constructors
    public Teacher(){}

    public Teacher(String firstName, String lastName, String email, int age, String mainSubject, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.mainSubject = mainSubject;
        this.salary = salary;
    }

    // getters and setters
    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMainSubject() {
        return mainSubject;
    }

    public void setMainSubject(String mainSubject) {
        this.mainSubject = mainSubject;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


    // toString
    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", mainSubject='" + mainSubject + '\'' +
                ", salary=" + salary +
                '}';
    }
}
