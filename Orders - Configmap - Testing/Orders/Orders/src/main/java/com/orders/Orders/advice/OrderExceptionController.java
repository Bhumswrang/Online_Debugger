package com.orders.Orders.advice;

import com.orders.Orders.exception.EmptyInputException;
import com.orders.Orders.exception.NullValueException;
import com.orders.Orders.exception.OrderNotFoundException;
import com.orders.Orders.exception.OrderWithIdAlreadyExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class OrderExceptionController {
    @ExceptionHandler(value = OrderNotFoundException.class)
    public ResponseEntity<String> exception(OrderNotFoundException exception)
    {
        return new ResponseEntity<>("No Order found with this Id", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = OrderWithIdAlreadyExistException.class)
    public ResponseEntity<String> exception(OrderWithIdAlreadyExistException exception)
    {
        return new ResponseEntity<>("Order with this Id already exists, Please change Order Id",HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = NullValueException.class)
    public ResponseEntity<String> exception(NullValueException exception)
    {
        return new ResponseEntity<>("Something went wrong in MS communication",HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = EmptyInputException.class)
    public ResponseEntity<String> exception(EmptyInputException exception)
    {
        return new ResponseEntity<>("Input field is empty, Please look into it",HttpStatus.BAD_REQUEST);
    }
}
