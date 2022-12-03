package com.example.practiceproject.DAO;

import com.example.practiceproject.Bean.Student;
public interface StudentDAO {
    Student login(Student student);
    Student getStudent(Integer studentId);
//    Student add(Student student);
}
