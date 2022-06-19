package com.example.obspringrest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("saludo")
    public String saludo(){
        return "hello world";
    }
}
