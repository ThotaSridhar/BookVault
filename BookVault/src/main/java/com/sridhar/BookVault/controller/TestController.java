package com.sridhar.BookVault.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/get")
    public String greet(){
        System.out.println("inside the test controller");
        return "hello";
    }
}
