package com.report.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @GetMapping("/login")
    public String showLoginForm(){
        return "login";
    }

    @GetMapping("/")
    public String homePage(){
        return "index";
    }

}
