package com.example.thymeleafapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private UserService userService;

    @RequestMapping("/detail")
    public String showProfile(Model model) {
        if (HomeController.getUserSession() != null) {
            UserModel user = (UserModel) HomeController.getUserSession().getAttribute("currentUser");
            model.addAttribute("user", user);
            model.addAttribute("img", user.getImage_path());
            System.out.println(user.getImage_path());
            return "details";
        }
        return "redirect:/login";
    }

}
