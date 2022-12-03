package com.example.practiceproject.Bean;
import jakarta.persistence.*;

@Entity
@Table(name = "bill")
public class Bill {
    @Id
    @Column(name="bill_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int billId;

    @Column(name = "amount",nullable = false)
    private int amount;

    @Column(name="bill_date",nullable = false)
    private String billDate;

    @ManyToOne
    private StudentPayments studentPayments;

    public Bill() {
    }

    public Bill(int amount, String billDate, StudentPayments studentPayments) {
        this.amount = amount;
        this.billDate = billDate;
        this.studentPayments = studentPayments;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    public StudentPayments getStudentPayments() {
        return studentPayments;
    }

    public void setStudentPayments(StudentPayments studentPayments) {
        this.studentPayments = studentPayments;
    }
}
