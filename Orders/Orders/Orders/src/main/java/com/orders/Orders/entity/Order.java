package com.orders.Orders.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Order_Table")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long oid;
    private LocalDate date;
    private LocalTime time;
    private long no_ofPizza;
    private long pid;
    private String p_name;
    private String price;
    private long uid;
    private String u_name;
    private String phone;
    private long code;


    public Order() {
    }

    public Order(long oid, long no_ofPizza, long code, long pid, long uid) {
        this.oid = oid;
        this.no_ofPizza = no_ofPizza;
        this.pid=pid;
        this.uid=uid;
    }


    public long getOid() {
        return oid;
    }

    public void setOid(long oid) {
        this.oid = oid;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public long getNo_ofPizza() {
        return no_ofPizza;
    }

    public void setNo_ofPizza(long no_ofPizza) {
        this.no_ofPizza = no_ofPizza;
    }

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
