package com.example.practiceproject.Service;


import com.example.practiceproject.Bean.Bill;
import com.example.practiceproject.DAO.impl.BillDAOImpl;
import java.util.*;

public class BillService {
    BillDAOImpl billDAO = new BillDAOImpl();

    public List<Bill> getBills(Integer paymentId){
        List<Bill> billList = billDAO.getBills(paymentId);

        return billList;
    }
}
