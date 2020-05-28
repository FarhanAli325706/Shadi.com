package com.example.thymeleafapp;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "feedback")
public class FeedBackModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer fID;
    private String description;
    private Integer user_id;

    public FeedBackModel() {
    }

    public FeedBackModel(Integer fID, String description, Integer user_id) {
        this.fID = fID;
        this.description = description;
        this.user_id = user_id;
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

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
}
