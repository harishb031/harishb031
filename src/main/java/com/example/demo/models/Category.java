package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter // to access private attributes we use getter and setter and this annottaion is coming from lambok
@Setter
@Entity
//hibenate creates table with same name
public class Category extends Baseclass {

    private long catid;
    private String cattitle;
    private String description;
    // we are using mapped by because we have already declared many to one cardinality in
    //products class, now if we tell one to many for same from here then hibernate will create mapping table between produc_id and ctaegory_id
    //which is not required in datbase so if we need to get list of products based on category_id we are using mapped keyword
    //we can get information through code but mapped table will not create in DB.
   @OneToMany(mappedBy = "category")
    private List<Products> products;
    }
