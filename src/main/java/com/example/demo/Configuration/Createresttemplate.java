package com.example.demo.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
@Configuration //to inform spring to create this object
public class Createresttemplate {
@Bean //to inform spring to create this object only once and use this evry time
    public RestTemplate createrest()
    {
        return new RestTemplate();
    }
}
