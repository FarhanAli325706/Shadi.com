package com.example.thymeleafapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {
    @Autowired
    FeedbackRepository feedbackRepository;


    public void save( FeedBackModel fmodel)
    {
        feedbackRepository.save(fmodel);
    }

    public Integer findMaxId() {
        Integer id = 0;
        List<FeedBackModel> listOfUser = feedbackRepository.findAll();
        for (FeedBackModel u :
                listOfUser) {
            if (u.getFid() > id) {
                id = u.getFid();
            }
        }
        ++id;
        return id;
    }
}
