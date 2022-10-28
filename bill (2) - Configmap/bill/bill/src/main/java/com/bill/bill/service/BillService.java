package com.bill.bill.service;

import com.bill.bill.entity.Bill;

import java.util.List;

public interface BillService {

    public List<Bill> getAllBill();
    public Bill getBillById(Long bill_id);
    public String addBill(Bill bill);
    public String updateBill(Bill bill);
    public String deleteBill(Long bill_id);

}
