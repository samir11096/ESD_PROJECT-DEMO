package com.example.practiceproject.DAO.impl;
import com.example.practiceproject.Util.HibernateSessionUtil;
import com.example.practiceproject.DAO.StudentDAO;
import com.example.practiceproject.Bean.Student;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class StudentDAOImpl implements StudentDAO{

    @Override
    public Student login(Student student){
        try (Session session = HibernateSessionUtil.getSession();){
            Integer studentId = student.getStudentID();
            String studentPassword = student.getPassword();

            Query q = session.createQuery("from Student where studentID =: studentId and password =: pass" ).setParameter("studentId",studentId).setParameter("pass",studentPassword);
            Student student1 = (Student)q.uniqueResult();
            return student1;
        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return null;
    }

    @Override
    public Student getStudent(Integer student_id){
        try(Session session = HibernateSessionUtil.getSession();){
            Query q = session.createQuery("from Student where studentID =:studentId").setParameter("studentId",student_id);
            Student student1 =(Student)q.uniqueResult();
            return student1;
        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return null;
    }

//    @Override
//    public Student add(Student student) {
//        try(Session session = HibernateSessionUtil.getSession()){
//            Transaction transaction = session.getTransaction();
//            session.save(student);
//            transaction.commit();
//
//            return student;
//        }
//        catch (HibernateException exception) {
//            System.out.println(exception.getLocalizedMessage());
//        }
//        return null;
//    }
}
