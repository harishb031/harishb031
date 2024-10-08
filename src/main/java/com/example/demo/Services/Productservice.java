package com.example.demo.Services;

import com.example.demo.models.Products;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface Productservice {

     Products getsingleproduct(long id);
     Page<Products> getallproducts(int page, int size);
     Products updateproduct(long id,Products product);
     void deleteproduct(long id);
     Products updatepostproduct(long id, Products products);

     Products addproduct(Products products);
}
