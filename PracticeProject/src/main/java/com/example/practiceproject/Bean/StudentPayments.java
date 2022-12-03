package com.example.practiceproject.Bean;
import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "student_payment")
public class StudentPayments{
    @Id
    @Column(name = "payment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentID;

    @Column(name = "total_amount",nullable = false)
    private int totalAmount;

    @Column(name ="paid_amount",nullable = false)
    private int paidAmount;

    @Column(name="payment_type")
    private String type;

    @Column(name="total_emi")
    private Integer totalEmi;

    @Column(name = "paid_emi")
    private Integer paidEmi;

    @Column(name = "status",nullable = false)
    private String status;

    @ManyToOne
    private Student stud;

//    @OneToMany(mappedBy = "studentPayments")
//    private List<Bill> billList;

    public StudentPayments() {
    }

    public StudentPayments(int totalAmount, int paidAmount, String type, Integer totalEmi, Integer paidEmi, String status, Student stud) {
        this.totalAmount = totalAmount;
        this.paidAmount = paidAmount;
        this.type = type;
        this.totalEmi = totalEmi;
        this.paidEmi = paidEmi;
        this.status = status;
        this.stud = stud;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(int paidAmount) {
        this.paidAmount = paidAmount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTotalEmi() {
        return totalEmi;
    }

    public void setTotalEmi(int totalEmi) {
        this.totalEmi = totalEmi;
    }

    public int getPaidEmi() {
        return paidEmi;
    }

    public void setPaidEmi(int paidEmi) {
        this.paidEmi = paidEmi;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Student getStud() {
        return stud;
    }

    public void setStud(Student stud) {
        this.stud = stud;
    }

}

