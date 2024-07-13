package com.example.demo.Services;

import com.example.demo.models.Products;

import java.util.List;

public interface Productservice {

     Products getsingleproduct(long id);
     List<Products> getallproducts();
     Products updateproduct(long id,Products product);
}
