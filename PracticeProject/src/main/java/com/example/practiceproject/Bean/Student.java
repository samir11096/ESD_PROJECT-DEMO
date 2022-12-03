package com.example.practiceproject.Bean;
import jakarta.persistence.*;
import org.hibernate.annotations.Generated;
import java.util.*;

@Entity
@Table(name="student")
public class Student {
    @Id
    @Column(name="student_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentID;

    @Column(name="email",nullable = false,unique = true)
    private String email;

    @Column(name="fname",nullable = false)
    private String firstName;

    @Column(name="lname",nullable = false)
    private String lastName;

    @Column(name="password",nullable = false)
    private String password;

//    @OneToMany(mappedBy = "stud")
//    private List<StudentPayments> studentPaymentsList;

    public Student() {
    }

    public Student(String email, String firstName, String lastName, String password) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public int getStudentID() {
        return studentID;
    }
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
