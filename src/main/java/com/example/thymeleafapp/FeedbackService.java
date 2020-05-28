package com.example.thymeleafapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService {
    @Autowired
    FeedbackRepository feedbackRepository;


    public void save( FeedBackModel fmodel)
    {
        feedbackRepository.save(fmodel);
    }

}
