package com.example.demo.Dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Fakestoreproductdtos {
    private long id ;
    private String title ;
    private String description;
    private String category;
    private double price;
    private int quantity;
}
