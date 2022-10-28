package com.orders.Orders.entity;



public class User {
    private long uid;
    private String u_name;
    private String phone;
    private String email;
    private String address;

    public User() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public User(long uid, String u_name, String phone, String email, String address) {
        this.uid = uid;
        this.u_name = u_name;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }
}
