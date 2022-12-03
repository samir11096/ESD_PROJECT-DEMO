package com.example.practiceproject.DAO;
import com.example.practiceproject.Bean.StudentPayments;
import java.util.List;
public interface StudentPaymentsDAO {
    List<StudentPayments> getPayments(Integer studentId);
//    StudentPayments add(StudentPayments payments);
}
