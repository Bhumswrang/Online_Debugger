package com.coupons.Coupons.advice;

import com.coupons.Coupons.exception.CouponNotFoundException;
import com.coupons.Coupons.exception.CouponWithIdAlreadyExistException;
import com.coupons.Coupons.exception.DuplicateEntryInDBException;
import com.coupons.Coupons.exception.EmptyInputException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CouponExceptionController extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = CouponNotFoundException.class)
    public ResponseEntity<String> exception(CouponNotFoundException exception)
    {
        return new ResponseEntity<>("No Coupon found with this Id", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = CouponWithIdAlreadyExistException.class)
    public ResponseEntity<String> exception(CouponWithIdAlreadyExistException exception)
    {
        return new ResponseEntity<>("Coupon with this Id already exists, Please change Coupon Id",HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = DuplicateEntryInDBException.class)
    public ResponseEntity<String> exception(DuplicateEntryInDBException exception)
    {
        return new ResponseEntity<>("You are making duplicate entry in DB",HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = EmptyInputException.class)
    public ResponseEntity<String> exception(EmptyInputException exception)
    {
        return new ResponseEntity<>("Input field  is empty, Please look into it",HttpStatus.BAD_REQUEST);
    }
}
