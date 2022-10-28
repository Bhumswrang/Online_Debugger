package com.coupons.Coupons.service;

import com.coupons.Coupons.entity.Coupon;
import com.coupons.Coupons.exception.CouponNotFoundException;
import com.coupons.Coupons.exception.CouponWithIdAlreadyExistException;
import com.coupons.Coupons.exception.DuplicateEntryInDBException;
import com.coupons.Coupons.exception.EmptyInputException;
import com.coupons.Coupons.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CouponServiceImpl implements CouponService {
    @Autowired
    private CouponRepository couponRepository;
    @Override
    public List<Coupon> getAllCoupon() {
        List<Coupon> coupons = new ArrayList<>();
        couponRepository.findAll().forEach(coupons::add);
        return coupons;
    }


    @Override
    public Coupon getCouponById(Long cid) {
//        Optional<Coupon> coupon = couponRepository.findById(cid);
//        return coupon.get();
        return couponRepository.findById(cid).orElseThrow(()->new CouponNotFoundException());
    }

    @Override
    public Coupon addCoupon(Coupon coupon) {
//        couponRepository.save(coupon);
//        return "Coupon Added Successfully";
//        if(String.valueOf(coupon.getCode()).length()==0 || String.valueOf(coupon.getOffer()).length()==0)
//            throw new EmptyInputException();
        if(coupon.getOffer()==0 || coupon.getCode()==0)
            throw new EmptyInputException();

        Optional<Coupon> c = couponRepository.findById(coupon.getCid());
        if (c.isPresent()){
            throw new CouponWithIdAlreadyExistException();
        }

        List<Coupon> coupons = new ArrayList<>();
        couponRepository.findAll().forEach(coupons::add);
        for(Coupon cc : coupons){
            if ((cc.getOffer()==(coupon.getOffer())) && (cc.getCode()==(coupon.getCode())))
            {
                throw new DuplicateEntryInDBException();
            }
        }

        couponRepository.save(coupon);
        return coupon;
    }

    @Override
    public String deleteCoupon(Long cid) {
    Optional<Coupon> coupon = couponRepository.findById(cid);
    if(coupon.isPresent()){
        couponRepository.delete(coupon.get());
        return "Coupon is deleted successfully";
    }
    else throw new CouponNotFoundException();
    }

    @Override
    public Long getOffer(Long code) {
        List<Coupon> coupons = new ArrayList<>();
        couponRepository.findAll().forEach(coupons::add);
        for(Coupon coupon : coupons){
            if (coupon.getCode()==code)
            {
                return coupon.getOffer();
            }
        }
        return null;
    }


}
