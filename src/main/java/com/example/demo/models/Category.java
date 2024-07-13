package com.example.demo.models;

import lombok.Getter;
import lombok.Setter;

@Getter // to access private attributes we use getter and setter and this annottaion is coming from lambok
@Setter
public class Category extends Baseclass {
    private long catid;
    private String cattitle;
    private String description;
    private Category category;

}
