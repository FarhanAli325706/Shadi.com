package com.example.thymeleafapp;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<FeedBackModel, Integer> {
}
