package com.pizzacatalogue.PizzaCatalogue.advice;

import com.pizzacatalogue.PizzaCatalogue.exception.DuplicateEntryInDBException;
import com.pizzacatalogue.PizzaCatalogue.exception.EmptyInputException;
import com.pizzacatalogue.PizzaCatalogue.exception.PizzaNotFoundException;
import com.pizzacatalogue.PizzaCatalogue.exception.PizzaWithIdAlreadyExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class PizzaCatalogueExceptionController extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = PizzaNotFoundException.class)
    public ResponseEntity<String> exception(PizzaNotFoundException exception)
    {
        return new ResponseEntity<>("No Pizza found with this Id", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = PizzaWithIdAlreadyExistException.class)
    public ResponseEntity<String> exception(PizzaWithIdAlreadyExistException exception)
    {
        return new ResponseEntity<>("Pizza  with this Id already exists, Please change Pizza Id",HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = DuplicateEntryInDBException.class)
    public ResponseEntity<String> exception(DuplicateEntryInDBException exception)
    {
        return new ResponseEntity<>("You are making duplicate entry in DB",HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = EmptyInputException.class)
    public ResponseEntity<String> exception(EmptyInputException exception)
    {
        return new ResponseEntity<>("Input field is empty, Please look into it",HttpStatus.BAD_REQUEST);
    }
}
