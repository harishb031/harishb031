package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class Products extends Baseclass {


   private long id;
    private String name;
    private double price;
@ManyToOne
    private Category category;

}

