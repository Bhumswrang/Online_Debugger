package com.bill.bill.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Bill {
    @Id
    private long bill_id;
    private String name;
    private String phone_no;
    private String price;
    private long no_of_pizza;
    private long code;
    private Double offer;
    private Double total_price;

    public Bill() {
    }

    public Bill(long bill_id) {
        this.bill_id = bill_id;
    }

    public long getNo_of_pizza() {
        return no_of_pizza;
    }

    public void setNo_of_pizza(long no_of_pizza) {
        this.no_of_pizza = no_of_pizza;
    }

    public long getBill_id() {
        return bill_id;
    }

    public void setBill_id(long bill_id) {
        this.bill_id = bill_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Double getOffer() {
        return offer;
    }

    public void setOffer(Double offer) {
        this.offer = offer;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public Double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(Double total_price) {
        this.total_price = total_price;
    }


    //    private long tax;
//    public Bill(long tax) {
//        this.tax = tax;
//    }


}
