package com.example.demo.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

//this model is created to store comman values in all the class
@Getter
@Setter
public class Baseclass {
    private long id;
    private Date updated_at;
    private Date created_at;
}
