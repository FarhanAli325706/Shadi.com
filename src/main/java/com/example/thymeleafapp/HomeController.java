package com.example.thymeleafapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/Welcome")
    public String homePage()
    {
        return "WelcomePage";
    }
    @RequestMapping("/index")
    public String index()
    {
        return "index";
    }
}
