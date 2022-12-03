package com.example.practiceproject.Service;
import com.example.practiceproject.Bean.StudentPayments;
import com.example.practiceproject.DAO.impl.StudentPaymentDAOImpl;
import java.util.List;

public class StudentPaymentService {
    StudentPaymentDAOImpl studentPaymentsDAO = new StudentPaymentDAOImpl();

    public List<StudentPayments> getPayments(Integer studentId){
        List<StudentPayments> studentPaymentsList = studentPaymentsDAO.getPayments(studentId);
        return studentPaymentsList;
    }
}
