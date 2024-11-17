package com.sridhar.BookVault.controller;


import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpRequest;

@RestController
public class TestController {
    private Logger logger = LoggerFactory.getLogger(TestController.class);
    @GetMapping("/get")
    public String greet(){
        System.out.println("inside the test controller");
        logger.trace("info in the test controller");
        logger.debug("debug in the test controller");
        logger.info("info int the controller");
        logger.warn("warn in the controller");
        logger.error("error in the controller");
        return "hello b boys ";
    }
    @GetMapping("/getcsrftoken")
    public CsrfToken getCsrf(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

}
