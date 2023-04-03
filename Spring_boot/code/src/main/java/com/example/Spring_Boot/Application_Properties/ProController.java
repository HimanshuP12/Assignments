package com.example.Spring_Boot.Application_Properties;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProController {


    @Autowired
    MyAppProperties myAppProperties;

    @RequestMapping("/pro")
    public MyAppProperties ProController(){
        return myAppProperties;
    }
}
