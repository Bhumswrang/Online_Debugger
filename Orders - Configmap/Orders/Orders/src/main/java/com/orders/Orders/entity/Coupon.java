package com.orders.Orders.entity;

public class Coupon {

    private long cid;
    private String code;
    private long offer;

    public Coupon() {
    }

    public Coupon(long cid, String code, long offer) {
        this.cid = cid;
        this.code = code;
        this.offer = offer;
    }

    public long getCid() {
        return cid;
    }

    public void setCid(long cid) {
        this.cid = cid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public long getOffer() {
        return offer;
    }

    public void setOffer(long offer) {
        this.offer = offer;
    }
}

