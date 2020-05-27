package com.example.thymeleafapp;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    UserService userService;
    FeedbackService feedbackService;
    private String email;
    private String feedback;

    @RequestMapping("/Welcome")
    public String homePage()
    {
        return "WelcomePage";
    }
    @RequestMapping("/login")
    public String login()
    {
        return "login";
    }
    @RequestMapping("/signup")
    public String signup()
    {
        return "signup";
    }
    @RequestMapping("/getuser")
    public String getUser(@RequestParam("email") String email, @RequestParam("password") String password)
    {
        UserModel result=userService.loginUser(email,password);
        return "WelcomePage";
    }
    @RequestMapping("/registeruser")
    public String registerUser(@RequestParam("fname") String fname, @RequestParam("lname") String lname, @RequestParam("email") String email, @RequestParam("password") String password, @RequestParam("religion") String religion, @RequestParam("country") String country, @RequestParam("city") String city, @RequestParam("cast") String cast, @RequestParam("gender") String gender, @RequestParam("birthdate") java.sql.Date birthdate)
    {
        //UserModel result=userService.loginUser(email,password);
        String username=fname+" "+lname;
        UserModel userModel=new UserModel();
        userModel.setUsername(username);
        userModel.setEmail(email);
        userModel.setUserpassword(password);
        userModel.setReligion(religion);
        userModel.setCountry(country);
        userModel.setCity(city);
        userModel.setUsercast(cast);
        userModel.setGender(gender);
        userModel.setBirthdate(birthdate);
        this.userService.signupUser(userModel);
        return "WelcomePage";
    }

    @RequestMapping("/feedback")
    public String Feedbackpage(){return "feedback";}
    @RequestMapping("/Userfeedback")
    public String enterFeedback(@RequestParam ("email") String email, @RequestParam("description") String feedback)
    {
        FeedBackModel fmodel = new FeedBackModel();
        UserModel user = new UserModel();
        List<UserModel> listOfUser=userService.userRepository.findAll();
        System.out.println(email + feedback);
        return "WelcomePage";
      /*  for(UserModel u: listOfUser)
        {
            if(user.getEmail().equals(email))
            {
                fmodel.setDescription(feedback);
                feedbackService.userRepository.save(user);
                return "WelcomePage";
            }
        }
        return "not user found";
*/    }
}
