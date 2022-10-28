package com.bill.bill.controller;

import com.bill.bill.entity.Bill;
import com.bill.bill.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class BillController {
    @Autowired
    private BillService billService;
    @RequestMapping("")
    public String home(){
        return "Bill Application";
    }

    @RequestMapping("bill/bills")
    public List<Bill> getAllBill(){
        return this.billService.getAllBill();
    }

    @RequestMapping("bill/bills/{bill_id}")
    public Bill getBillById(@PathVariable Long bill_id){
        return this.billService.getBillById(bill_id);
    }


    @RequestMapping(value = "bill/bills/", method = RequestMethod.POST)
    public String addBill(@RequestBody Bill bill){
        return this.billService.addBill(bill);
    }

    @RequestMapping(value = "bill/bills/{bill_id}", method = RequestMethod.PUT)
    public String updateBill(@RequestBody Bill bill){
        return this.billService.updateBill(bill);
    }

    @RequestMapping(value = "bill/bills/{bill_id}", method = RequestMethod.DELETE)
    public String deleteBill(@PathVariable Long bill_id){
        return this.billService.deleteBill(bill_id);
    }

}
