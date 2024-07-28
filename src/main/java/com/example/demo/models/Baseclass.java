package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

//this model is created to store comman values in all the class
@Getter
@Setter
@MappedSuperclass //no object for this class but we need these attributes in other tables
//above annottaion comes in topic inheritance of DB
public class Baseclass {
   @Id //to tell its a primary key
   @GeneratedValue(strategy = GenerationType.IDENTITY)//Auto increment
    private Long id;
    private Date updated_at;
    private Date created_at;
    }
