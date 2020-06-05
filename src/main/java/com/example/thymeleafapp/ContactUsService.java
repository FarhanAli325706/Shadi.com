package com.example.thymeleafapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactUsService {
    @Autowired
    ContactUsRepository contactUsRepository;

    public void save( ContactUsModel contactUsModel)
    {
        contactUsRepository.save(contactUsModel);
    }
}
