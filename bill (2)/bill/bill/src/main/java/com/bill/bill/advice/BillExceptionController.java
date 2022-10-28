package com.bill.bill.advice;
import com.bill.bill.exception.BillIdAlreadyExistException;
import com.bill.bill.exception.BillIdNotExistException;
import com.bill.bill.exception.EmptyInputException;
import com.bill.bill.exception.OrderIdNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BillExceptionController {
    @ExceptionHandler(value = OrderIdNotExistException.class)
    public ResponseEntity<String> exception(OrderIdNotExistException exception)
    {
        return new ResponseEntity<>("Can't create bill for this Order, Because this order doesn't exist ", HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = BillIdAlreadyExistException.class)
    public ResponseEntity<String> exception(BillIdAlreadyExistException exception)
    {
        return new ResponseEntity<>("Bill for this Order already exist, Please change order no.", HttpStatus.CONFLICT);
    }
    @ExceptionHandler(value = BillIdNotExistException.class)
    public ResponseEntity<String> exception(BillIdNotExistException exception)
    {
        return new ResponseEntity<>(" Bill with this Id doesn't exists", HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = EmptyInputException.class)
    public ResponseEntity<String> exception(EmptyInputException exception)
    {
        return new ResponseEntity<>("Input field is empty, Please look into it", HttpStatus.BAD_REQUEST);
    }

}
