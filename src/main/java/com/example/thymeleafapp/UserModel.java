package com.example.thymeleafapp;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;
@Entity
@Table(name = "user_data")
public class UserModel implements Serializable {
    @Id
    private Integer userid;
    private String email;
    private String userpassword;
    private String city;
    private String religion;
    private String country;
    private String usercast;
    private java.sql.Date birthdate;
    private String username;
    private String gender;


    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public UserModel(Integer userid, String email, String userpassword, String city, String religion, String country, String usercast, Date birthdate, String username, String gender) {
        this.userid = userid;
        this.email = email;
        this.userpassword = userpassword;
        this.city = city;
        this.religion = religion;
        this.country = country;
        this.usercast = usercast;
        this.birthdate = birthdate;
        this.username=username;
        this.gender = gender;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getUsercast() {
        return usercast;
    }

    public void setUsercast(String usercast) {
        this.usercast = usercast;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public UserModel()
    {

    }


}
