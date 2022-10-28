package com.bill.bill.service;

import com.bill.bill.entity.Bill;
import com.bill.bill.entity.Order;
import com.bill.bill.exception.BillIdAlreadyExistException;
import com.bill.bill.exception.BillIdNotExistException;
import com.bill.bill.exception.EmptyInputException;
import com.bill.bill.exception.OrderIdNotExistException;
import com.bill.bill.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BillServiceImpl implements BillService {
    @Autowired
    private BillRepository billRepository;

    @Override
    public List<Bill> getAllBill() {
        List <Bill> bills = new ArrayList<>();
        billRepository.findAll().forEach(bills::add);
        return bills;
    }

    @Override
    public Bill getBillById(Long bill_id) {
        Optional<Bill> bill = billRepository.findById(bill_id);
        if(bill.isPresent()){
            return bill.get();
        }
        throw new BillIdNotExistException();
    }


    @Value("${order.service}")
    String order_service;

    @Value("${offer.service}")
    String offer_service;

    @Autowired
    RestTemplate restTemplate;


    @Override
    public String addBill(Bill bill) {


        if(bill.getBill_id()==0)
            throw new EmptyInputException();

        Optional<Bill> b = billRepository.findById(bill.getBill_id());
        if (b.isPresent()){
            throw new BillIdAlreadyExistException();
        }
        Order order = this.restTemplate.getForObject(order_service + bill.getBill_id(),Order.class);
       // Order order = this.restTemplate.getForObject("http://localhost:8089/order/orders/"+bill.getBill_id(),Order.class);
        if(order!=null){
        bill.setName(order.getU_name());
        bill.setPhone_no(order.getPhone());
        bill.setPrice(order.getPrice());
        bill.setNo_of_pizza(order.getNo_ofPizza());
        bill.setCode(order.getCode());

            Long offer_percentage = this.restTemplate.getForObject(offer_service + bill.getCode(),Long.class);
        //Long offer_percentage = this.restTemplate.getForObject("http://localhost:8081/coupon/getOffer/"+bill.getCode(),Long.class);
        if(offer_percentage==null){
            offer_percentage = 0L;
        }
        Double p = Double.parseDouble(bill.getPrice());

        Double offer = (offer_percentage * p * bill.getNo_of_pizza())/100;
        Double totalPrice = bill.getNo_of_pizza()*p - offer;

        bill.setOffer(offer);
        bill.setTotal_price(totalPrice);
        billRepository.save(bill);
        return "Bill added successfully";
    }
    else{
        throw new OrderIdNotExistException();
    }
    }

    @Override
    public String updateBill(Bill bill) {
        if(billRepository.existsById(bill.getBill_id())){
            billRepository.save(bill);
            return "Updated Successfully";
        }
      return "Bill do not exist";
    }

    @Override
    public String deleteBill(Long bill_id) {
        Optional<Bill> bill = billRepository.findById(bill_id);
        if(bill.isPresent()){
            billRepository.delete(bill.get());
            return "Deleted successfully";
        }
        throw new BillIdNotExistException();
    }
}
