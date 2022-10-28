package com.coupons.Coupons.entity;

import javax.persistence.*;

@Entity
@Table(name = "Coupon_Table")
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long cid;
    @Column(unique = true)
    private long code;
    private long offer;

    public Coupon() {
    }

    public Coupon(long cid, long code, long offer) {
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

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public long getOffer() {
        return offer;
    }

    public void setOffer(long offer) {
        this.offer = offer;
    }
}
