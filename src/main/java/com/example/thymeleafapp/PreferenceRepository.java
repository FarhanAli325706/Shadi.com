package com.example.thymeleafapp;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PreferenceRepository extends JpaRepository<PreferenceModel, Integer> {
}
