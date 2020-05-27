package com.example.thymeleafapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public boolean loginUser(String email, String password, HttpSession session)
    {
        List<UserModel> listOfUser=userRepository.findAll();
        int flag=0;
        for (UserModel u : listOfUser)
        {
            if(u.getEmail().equals(email) && u.getUserpassword().equals(password))
            {
                session.setAttribute("currentUser",u);
                flag=1;
                break;
            }
        }
        if(flag==1)
            return true;
        return false;
    }

    public void signupUser(UserModel u) {
        List<UserModel> listOfUser = userRepository.findAll();
        u.setUserid(listOfUser.size() + 1);
        this.userRepository.save(u);
    }
}
