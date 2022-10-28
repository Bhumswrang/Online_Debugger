package com.coupons.Coupons.service;

import com.coupons.Coupons.entity.Coupon;

import java.util.List;

public interface CouponService {
    public List<Coupon> getAllCoupon();

    public Coupon getCouponById(Long cid);

    public Coupon addCoupon(Coupon coupon);

    public String deleteCoupon(Long cid);

    public Long getOffer(Long code);

}
