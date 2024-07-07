package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// we are using above annottaion to tell this class will be hosting a set http API's to
@RequestMapping("/say")
//to get the address of this class.....what is the address of this class ? ans : in this example its /hello
public class samplecontroller {

    @GetMapping("/say")
    //to get something we are using this annotaion
    public String sayHello() {
        return "hello harish anna";
    }

    @GetMapping("/harish/{name}")
    public String harish(@PathVariable("name") String name) {

        return "harish " + name +" are not good friends";
        //what we achieved here is whatever we are passing in the path after /harish its taking as a variable
        //and to achieve this we are using pathvariable annotttaion in our function
    }
    @GetMapping("/nayi")
    public int harish()
    {
        System.out.println("harish");
        return 1;
    }
}
