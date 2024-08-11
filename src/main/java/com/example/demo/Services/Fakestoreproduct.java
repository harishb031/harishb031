package com.example.demo.Services;

import com.example.demo.Dtos.Fakestoreproductdtos;
import com.example.demo.models.Category;
import com.example.demo.models.Products;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.ArrayList;
import java.util.List;
@Service //to tell spring to create object of this class we use this annottaion


//here we have implemented all methods of Fakestoreproduct interface
//if we dont implement then it will not let u to create this class
//including @ovveride is all came automatically after clicking implement methods
public class Fakestoreproduct implements Productservice{

    RestTemplate restTemplate;
    public Fakestoreproduct(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;

        //resttemplate is a special type of inbuilt class which uses to call http
        //inthis ex we have to call fakestore
    }
    public Products getsingleproduct(long id) {
    Fakestoreproductdtos fakestoreproductdtos = restTemplate.getForObject("https://fakestoreapi.com/products/"+id, Fakestoreproductdtos.class);
    //getforobject is a in built method that gives output and we are calling that using Resttemplate
    //.class tell that out put need to be in that class type

    //now we need to convert fakestore object into product type because thats our output format as mentioned in class
//createproduct is created for conversion


       return createproduct(fakestoreproductdtos);
// throw new ArithmeticException();        //throw new ArithmeticException();

    }

    @Override
    public Page<Products> getallproducts(int page, int size) {
        return null;
    }


    public List<Products> getallproducts() {
       Fakestoreproductdtos[] fakestoreproductdtos = restTemplate.getForObject("https://fakestoreapi.com/products", Fakestoreproductdtos[].class);

        List<Products> products = new ArrayList<>();
        for(Fakestoreproductdtos fakestoreproductdto : fakestoreproductdtos){
            products.add(createproduct(fakestoreproductdto));
        }

        return products;
    }


    public Products updateproduct(long id, Products product) {
        RequestCallback requestCallback = restTemplate.httpEntityCallback(product, Fakestoreproductdtos.class);
        HttpMessageConverterExtractor<Fakestoreproductdtos> responseExtractor = new HttpMessageConverterExtractor(Fakestoreproductdtos.class, restTemplate.getMessageConverters());
        Fakestoreproductdtos response = restTemplate.execute("https://fakestoreapi.com/products/"+id, HttpMethod.PATCH, requestCallback, responseExtractor);
         return createproduct(response);
    }

    @Override
    public void deleteproduct(long id) {

    }

    @Override
    public Products updatepostproduct(long id, Products products) {
        return null;
    }


    public Products addproduct(Products products) {
        return null;
    }

    public Products createproduct(Fakestoreproductdtos fakestoreproductdtos) {
        Products product = new Products();
        product.setId(fakestoreproductdtos.getId());
        product.setName(fakestoreproductdtos.getTitle());
        product.setPrice(fakestoreproductdtos.getPrice());
        Category category = new Category();
        category.setDescription(fakestoreproductdtos.getCategory());
      product.setCategory(category);
        return product;
    }
}
