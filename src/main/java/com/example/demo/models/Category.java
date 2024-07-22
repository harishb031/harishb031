package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter // to access private attributes we use getter and setter and this annottaion is coming from lambok
@Setter
@Entity
//hibenate creates table with same name
public class Category extends Baseclass {

    private long catid;
    private String cattitle;
    private String description;
    }
