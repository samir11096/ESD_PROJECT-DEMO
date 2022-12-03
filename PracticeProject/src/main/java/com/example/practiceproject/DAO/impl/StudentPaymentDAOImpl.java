package com.example.practiceproject.DAO.impl;

import com.example.practiceproject.Bean.Student;
import com.example.practiceproject.Util.HibernateSessionUtil;
import com.example.practiceproject.DAO.StudentPaymentsDAO;
import com.example.practiceproject.Bean.StudentPayments;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.*;

public class StudentPaymentDAOImpl implements StudentPaymentsDAO {

    @Override
    public List<StudentPayments> getPayments(Integer student_id){
        List<StudentPayments> student_payment_list = new ArrayList<>();
        try (Session session = HibernateSessionUtil.getSession()){
            for (
                    final Object student_payment : session
                    .createQuery("FROM StudentPayments WHERE stud.studentID=:s_id")
                    .setParameter("s_id", student_id).list()
            )
                student_payment_list.add((StudentPayments) student_payment);
        }
        catch (HibernateException exception) {
            System.out.println(exception.getLocalizedMessage());
        }

        return student_payment_list;
    }

//    @Override
//    public StudentPayments add(StudentPayments payments) {
//        try(Session session = HibernateSessionUtil.getSession()){
//            Transaction transaction = session.getTransaction();
//            session.save(payments);
//            transaction.commit();
//
//            return payments;
//        }
//        catch (HibernateException exception) {
//            System.out.println(exception.getLocalizedMessage());
//        }
//        return null;
//    }
}
