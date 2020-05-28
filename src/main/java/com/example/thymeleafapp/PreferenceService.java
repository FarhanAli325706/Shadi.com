package com.example.thymeleafapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreferenceService {
    @Autowired
    PreferenceRepository preferenceRepository;
    @Autowired
    UserRepository userRepository;
    public Integer storePreference(PreferenceModel p) {
        List<PreferenceModel> listOfPreferences = preferenceRepository.findAll();
        p.setPreference_id(listOfPreferences.size() + 1);
        this.preferenceRepository.save(p);
        return p.getPreference_id();
    }
    void updatePreference(Integer preference_id, Integer currentUserid)
    {
        List<UserModel> listOfUser=userRepository.findAll();
        for (UserModel u : listOfUser)
        {
            if(currentUserid.equals(u.getUserid()))
            {
                u.setPreference_id(preference_id);
                userRepository.save(u);
                break;
            }
        }

    }
}
