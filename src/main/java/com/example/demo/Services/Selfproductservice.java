package com.example.demo.Services;

import com.example.demo.Repo.CategoryRepo;
import com.example.demo.Repo.ProductRepo;
import com.example.demo.models.Category;
import com.example.demo.models.Products;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Primary
@Service
public class Selfproductservice implements Productservice{
    private ProductRepo productRepo;
    private CategoryRepo categoryRepo;

    public Selfproductservice(ProductRepo productRepo,CategoryRepo categoryRepo) {
        this.productRepo = productRepo;
        this.categoryRepo = categoryRepo;
    }
    public Products getsingleproduct(long id) {

    Optional<Products> productsOptional = productRepo.findById(id);

        if (productsOptional.isEmpty())
        {
            throw new RuntimeException();
        }

        return productsOptional.get();
    }


    public Page<Products> getallproducts(int Pagenumber,int pagesize ) {
        Page<Products> productsList = productRepo.findAll(
        PageRequest.of(Pagenumber,pagesize));

        return productsList;

    }


    public Products updateproduct(long id, Products product) {
Optional<Products> productsOptional1 = productRepo.findById(id);
        if (productsOptional1.isEmpty())
        {
            throw new RuntimeException();
        }
        Products products1 = productsOptional1.get();
        if (product.getId() !=null)
        {
            products1.setId(product.getId());
        }
        if (product.getName() !=null)
        {
            products1.setName(product.getName());
        }

            products1.setPrice(product.getPrice());


        return productRepo.save(products1);
    }


    public void deleteproduct(long id) {
        productRepo.deleteById(id);

    }

//save is the function name to do update and create
 //   its also called as a upsert
    //if we pass id then it updates else it creates new product

    public Products addproduct(Products products) {

        // when we are passing request body which contains non existent category id then we get persistent error
        //to avoid that error we have to check category id is avaiable or not
        //if its not available then we have to save category object first (below code) or we have to mention CaSCade in products
       //Below code is only required when we are not using CASCADE in product class
      /*  Category category = products.getCategory();
        if (category.getId() == null)
        {
            // here savedcategory contains id because its passed through save method;
            Category savedcategory = categoryRepo.save(category);
           products.setCategory(savedcategory);
        }
            */

        return productRepo.save(products);
    }


    public Products updatepostproduct(long id, Products product) {
        Optional<Products> productsOptional1 = productRepo.findById(id);
        if (productsOptional1.isEmpty()) {
            throw new RuntimeException();
        }
        Products products1 = productsOptional1.get();


        if (product.getName() != null) {
            products1.setName(product.getName());
        }

        products1.setPrice(product.getPrice());
       return products1;
    }
    }
