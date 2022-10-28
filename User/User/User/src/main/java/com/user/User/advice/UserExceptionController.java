package com.user.User.advice;

import com.user.User.exception.DuplicateEntryInDBException;
import com.user.User.exception.EmptyInputException;
import com.user.User.exception.UserNotFoundException;
import com.user.User.exception.UserWithIdAlreadyExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class UserExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<String> exception(UserNotFoundException exception)
    {
        return new ResponseEntity<>("No User found with this Id", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = UserWithIdAlreadyExistException.class)
    public ResponseEntity<String> exception(UserWithIdAlreadyExistException exception)
    {
        return new ResponseEntity<>("User  with this Id already exists, Please change User Id",HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = DuplicateEntryInDBException.class)
    public ResponseEntity<String> exception(DuplicateEntryInDBException exception)
    {
        return new ResponseEntity<>("You are making duplicate entry in DB",HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = EmptyInputException.class)
    public ResponseEntity<String> exception(EmptyInputException exception)
    {
        return new ResponseEntity<>("Input field (Name) is empty, Please look into it",HttpStatus.BAD_REQUEST);
    }

}
