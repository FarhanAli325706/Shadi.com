package com.example.thymeleafapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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

    @RequestMapping("/editprofile")
    public String editProfile(Model model) {
        if (HomeController.getUserSession() != null) {
            model.addAttribute("user", (UserModel) HomeController.getUserSession().getAttribute("currentUser"));
            return "edit";
        }
        return "redirect:/login";
    }

    @RequestMapping("/saveuser")
    public String saveUser(@RequestParam("fname") String fname, @RequestParam("lname") String lname, @RequestParam("email") String email, @RequestParam("password") String password, @RequestParam("religion") String religion, @RequestParam("country") String country, @RequestParam("city") String city, @RequestParam("cast") String cast, @RequestParam("gender") String gender, @RequestParam("birthdate") java.sql.Date birthdate, @RequestParam("imageFile") MultipartFile imageFile) {
        if (HomeController.getUserSession() != null) {
            String username = fname + " " + lname;
            UserModel userModel = (UserModel) HomeController.getUserSession().getAttribute("currentUser");
            String img_path = userService.saveImage(imageFile);
            userModel.setUsername(username);
            userModel.setEmail(email);
            userModel.setUserpassword(password);
            userModel.setReligion(religion);
            userModel.setCountry(country);
            userModel.setCity(city);
            userModel.setUsercast(cast);
            userModel.setGender(gender);
            userModel.setBirthdate(birthdate);
            userModel.setImage_path(img_path);
            userService.userRepository.save(userModel);
            return "redirect:/profile/detail";
        }
        return "redirect:/login";
    }
}
