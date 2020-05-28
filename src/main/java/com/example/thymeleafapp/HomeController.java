package com.example.thymeleafapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    UserService userService;
    @Autowired
    PreferenceService preferenceService;
    FeedbackService feedbackService;
    static private HttpSession userSession;
    private String email;
    private String feedback;

    @RequestMapping("/Welcome")
    public String homePage() {
        return "WelcomePage";
    }

    @RequestMapping("/index")
    public String test() {
        if (userSession != null)
            return "index";
        return "login";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/signup")
    public String signup() {
        return "signup";
    }

    @RequestMapping("/getuser")
    public String getUser(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session) {
        if (userService.loginUser(email, password, session))
            this.userSession = session;
        return "redirect:/profile/detail";
    }

    static public HttpSession getUserSession() {
        return userSession;
    }

    @RequestMapping("/registeruser")
    public String registerUser(@RequestParam("fname") String fname, @RequestParam("lname") String lname, @RequestParam("email") String email, @RequestParam("password") String password, @RequestParam("religion") String religion, @RequestParam("country") String country, @RequestParam("city") String city, @RequestParam("cast") String cast, @RequestParam("gender") String gender, @RequestParam("birthdate") java.sql.Date birthdate, @RequestParam("imageFile") MultipartFile imageFile) {
        //UserModel result=userService.loginUser(email,password);
        String username = fname + " " + lname;
        UserModel userModel = new UserModel();
        String img_path = userService.saveImage(imageFile);
        userModel.setUserid(userService.findMaxId());
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
        this.userService.signupUser(userModel);
        return "redirect:/login";
    }

    @RequestMapping("/feedback")
    public String Feedbackpage() {
        return "feedback";
    }

 
        @RequestMapping("/setpreferences")
        public String setPreferences()
        {
            return "preferences";
        }
        @RequestMapping("/storepreferences")
        public String storePreferences(@RequestParam("religion") String religion, @RequestParam("country") String country, @RequestParam("city") String city, @RequestParam("cast") String cast, @RequestParam("gender") String gender, @RequestParam("age") Integer age)
        {
            PreferenceModel preferenceModel = new PreferenceModel();
            preferenceModel.setReligion(religion);
            preferenceModel.setCountry(country);
            preferenceModel.setCity(city);
            preferenceModel.setPartnercast(cast);
            preferenceModel.setGender(gender);
            preferenceModel.setAge(age);
            Integer preference_id=this.preferenceService.storePreference(preferenceModel);
            UserModel currentUser=(UserModel)userSession.getAttribute("currentUser");
            this.updatePreference(preference_id,currentUser.getUserid());
            return "details";
        }
        @RequestMapping("/updatepreference")
        public void updatePreference(Integer preference_id, Integer currentUserid)
        {
            this.preferenceService.updatePreference(preference_id,currentUserid);
        }

}
