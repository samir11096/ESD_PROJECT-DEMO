package com.example.practiceproject.DAO.impl;
import com.example.practiceproject.Util.HibernateSessionUtil;
import com.example.practiceproject.DAO.BillDAO;
import com.example.practiceproject.Bean.Bill;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class BillDAOImpl implements BillDAO{
    @Override
    public List<Bill> getBills(Integer paymentID){

        List<Bill> billList = new ArrayList<>();
        try(Session session = HibernateSessionUtil.getSession()){
            for(Object bill : session
                    .createQuery("from Bill where studentPayments.paymentID=:paymentID")
                    .setParameter("paymentID", paymentID).list()
            )
                billList.add((Bill) bill);
        }
        catch (HibernateException exception) {
            System.out.println(exception.getLocalizedMessage());
        }
        return billList;
    }

    @Override
    public Bill add(Bill bill) {
        try(Session session = HibernateSessionUtil.getSession()){
            Transaction transaction = session.getTransaction();
            session.save(bill);
            transaction.commit();

            return bill;
        }
        catch (HibernateException exception) {
            System.out.println(exception.getLocalizedMessage());
        }
        return null;
    }

}
