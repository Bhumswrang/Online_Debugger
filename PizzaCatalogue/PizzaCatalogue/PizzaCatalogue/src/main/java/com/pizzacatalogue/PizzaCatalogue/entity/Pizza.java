package com.pizzacatalogue.PizzaCatalogue.entity;

import javax.persistence.*;

@Entity
@Table(name = "Pizza_Catalogue")
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long pid;
    private String p_name;
    private String type;
    private String price;

    public Pizza() {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Pizza(long pid, String p_name, String type, String price) {
        this.pid = pid;
        this.p_name = p_name;
        this.type = type;
        this.price = price;
    }
}
