package com.example.demo.Services;

import com.example.demo.models.Products;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface Productservice {

     Products getsingleproduct(long id);
     List<Products> getallproducts();
     Products updateproduct(long id,Products product);
     void deleteproduct(long id);
     Products addproduct(@RequestBody Products products);
}
