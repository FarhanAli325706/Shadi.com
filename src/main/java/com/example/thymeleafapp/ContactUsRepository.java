package com.example.thymeleafapp;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactUsRepository extends JpaRepository<ContactUsModel, Integer> {
}
