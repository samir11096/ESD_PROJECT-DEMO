package com.example.practiceproject.DAO;

import com.example.practiceproject.Bean.Bill;
import java.util.List;

public interface BillDAO {
    List<Bill> getBills(Integer paymentID);
    Bill add(Bill bill);
}
