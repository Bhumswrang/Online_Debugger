package com.coupons.Coupons.repository;

import com.coupons.Coupons.entity.Coupon;
import org.springframework.data.repository.CrudRepository;

public interface CouponRepository extends CrudRepository<Coupon,Long> {
}
