package com.coupons.Coupons.controller;
import com.coupons.Coupons.entity.Coupon;
import com.coupons.Coupons.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class CouponController {
    @Autowired
    private CouponService couponService;

    @RequestMapping("")
    public String home()
    {
        return "This is coupon api";
    }

    @RequestMapping("/coupon/coupons")
    public List<Coupon> getAllCoupon(){
        return this.couponService.getAllCoupon();
    }

    @RequestMapping("/coupon/coupons/{cid}")
    public Coupon getCouponById(@PathVariable Long cid){
        return this.couponService.getCouponById(cid);
    }

    @RequestMapping(value = "/coupon/coupons" , method = RequestMethod.POST)
    public Coupon addCoupon(@RequestBody Coupon coupon){
        return this.couponService.addCoupon(coupon);
    }

    @RequestMapping(value = "/coupon/coupons/{cid}" , method = RequestMethod.DELETE)
    public String deleteCoupon(@PathVariable Long cid){
        return this.couponService.deleteCoupon(cid);
    }

    @RequestMapping("/coupon/getOffer/{code}")
    public Long getOffer(@PathVariable Long code){return this.couponService.getOffer(code);}

}
