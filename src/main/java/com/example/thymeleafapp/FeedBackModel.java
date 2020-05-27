package com.example.thymeleafapp;

import javax.persistence.*;

@Entity
@Table(name = "feedback")
public class FeedBackModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer fID;
    private String description;

    @JoinColumn(name = "userID")
    private UserModel user;

    public FeedBackModel(String description, UserModel user) {
        this.description = description;
        this.user = user;
    }

    public FeedBackModel() {
    }

    public Integer getfID() {
        return fID;
    }

    public void setfID(Integer fID) {
        this.fID = fID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }
}
