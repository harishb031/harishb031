package com.example.demo.Controlleradvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

//its a GLOBAL exception
@ControllerAdvice
public class Globalexception {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<String> exception() {
        ResponseEntity<String> response = new ResponseEntity<>("its comming from advice", HttpStatus.BAD_GATEWAY);

        return response;
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<String> exceptionn() {
        ResponseEntity<String> response = new ResponseEntity<>("its comming from a device no exception", HttpStatus.BAD_GATEWAY);

        return response;
    }

}
