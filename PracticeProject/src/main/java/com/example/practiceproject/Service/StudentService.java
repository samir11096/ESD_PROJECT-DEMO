package com.example.practiceproject.Service;
import com.example.practiceproject.Bean.Student;
import com.example.practiceproject.DAO.impl.StudentDAOImpl;

public class StudentService {
    StudentDAOImpl studentDAO = new StudentDAOImpl();

    public Student login(Student student) {
        Student loggedInStudent = studentDAO.login(student);

        if (loggedInStudent == null) {
            return null;
        }

        return loggedInStudent;
    }


}
