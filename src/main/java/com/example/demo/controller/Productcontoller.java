package com.example.demo.controller;

import com.example.demo.Dtos.Exceptiondtos;
import com.example.demo.Services.Productservice;
import com.example.demo.models.Products;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class Productcontoller {

    // in java to call anything we have use objects
    //to make controler to call product service interface we have to create object of interface
    //object is created by spring boot
    //we cant create object of interface so we have to create object of class which is implementing this interface
    //from line 23 to 24 indicates dependency injection using controller means we have  injected object of fake store in this example

    Productservice productservice;

    public Productcontoller(Productservice productservice) {
        this.productservice = productservice;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Products> getproductbyid(@PathVariable("id") long id) // here we are expecting output of Products
    {
        ResponseEntity<Products> responseEntity = null;
     /*   try {
            Products products = productservice.getsingleproduct(id);
            responseEntity = new ResponseEntity<>(products, HttpStatus.OK);
        }
        catch (RuntimeException e)
        {
             responseEntity = new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }   */

        Products products = productservice.getsingleproduct(id);
        responseEntity = new ResponseEntity<>(products, HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping()
    public List<Products> getproducts() {

        return productservice.getallproducts();
    }

    @PatchMapping("/{id}")
    public Products updateproduct(@PathVariable("id") long id, @RequestBody Products products) {
        return productservice.updateproduct(id, products);
    }

    @DeleteMapping("/{id}")
    public void deleteproduct(@PathVariable("id") long id) {
        productservice.deleteproduct(id);
    }

    @PostMapping()
    public Products addproduct(@RequestBody Products products) {
        return productservice.addproduct(products);
    }


    //public Products replaceproduct(long id,Products)
// if u want exception to be specific to specific contoller then we have to write code in controller like below
    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<String> exceptionnn() {
        ResponseEntity<String> response = new ResponseEntity<>("its comming from a contoller", HttpStatus.BAD_GATEWAY);

        return response;

    }

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<Exceptiondtos> exception() {
        Exceptiondtos exceptiondtos =  new Exceptiondtos();
     exceptiondtos.setMessage("its error loafer");
        exceptiondtos.setSolution("i dont no the solution");
        ResponseEntity<Exceptiondtos> response = new ResponseEntity<>(exceptiondtos, HttpStatus.BAD_GATEWAY);

        return response;
    }
}
