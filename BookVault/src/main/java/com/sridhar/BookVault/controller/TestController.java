package com.sridhar.BookVault.controller;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpRequest;

@RestController
public class TestController {
    @GetMapping("/get")
    public String greet(){
        System.out.println("inside the test controller");
        return "hello";
    }
    @GetMapping("/getcsrftoken")
    public CsrfToken getCsrf(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

}
