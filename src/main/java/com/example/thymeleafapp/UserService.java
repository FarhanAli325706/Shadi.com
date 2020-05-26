package com.example.thymeleafapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public UserModel loginUser(String email, String password)
    {
        int flag=0;
        List<UserModel> listOfUser=userRepository.findAll();
        UserModel resultanUser=new UserModel();
        for (UserModel u : listOfUser)
        {
            if(u.getEmail().equals(email) && u.getUserpassword().equals(password))
            {
                resultanUser.setUserid(u.getUserid());
                resultanUser.setUsername(u.getUsername());
                resultanUser.setUserpassword(u.getUserpassword());
                resultanUser.setEmail(u.getEmail());
                resultanUser.setGender(u.getGender());
                resultanUser.setBirthdate(u.getBirthdate());
                resultanUser.setCity(u.getCity());
                resultanUser.setReligion(u.getReligion());
                resultanUser.setCountry(u.getCountry());
                resultanUser.setUsercast(u.getUsercast());
                flag=1;
                break;
            }
        }
        if(flag==1)
            return resultanUser;
        return null;
    }
    public void signupUser(UserModel u)
    {
        List<UserModel> listOfUser=userRepository.findAll();
        u.setUserid(listOfUser.size()+1);
        this.userRepository.save(u);
    }
}
