package com.example.thymeleafapp;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @Autowired
    UserService userService;
    @RequestMapping("/Welcome")
    public String homePage()
    {
        return "WelcomePage";
    }
    @RequestMapping("/login")
    public String signup()
    {
        return "login";
    }
    @RequestMapping("/getuser")
    public String getUser(@RequestParam("email") String email, @RequestParam("password") String password)
    {
        UserModel result=userService.loginUser(email,password);
        return "WelcomePage";
    }
}
