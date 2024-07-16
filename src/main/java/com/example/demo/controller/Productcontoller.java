package com.example.demo.controller;

import com.example.demo.Services.Productservice;
import com.example.demo.models.Products;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Products> getproductbyid(@PathVariable ("id") long id) // here we are expecting output of Products
    {
        ResponseEntity<Products> responseEntity = null;
        try {
            Products products = productservice.getsingleproduct(id);
            responseEntity = new ResponseEntity<>(products, HttpStatus.OK);
        }
        catch (RuntimeException e)
        {
             responseEntity = new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }


           return responseEntity;
    }
    @GetMapping()
    public List<Products> getproducts()
    {

        return productservice.getallproducts();
    }

    @PatchMapping("/{id}")
    public Products updateproduct(@PathVariable("id") long id,@RequestBody Products products)
    {
             return productservice.updateproduct(id,products);
    }
    //public Products replaceproduct(long id,Products)

}
