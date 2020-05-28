package com.example.thymeleafapp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "preferences")
public class PreferenceModel {
    @Id
    private Integer preference_id;
    private String city;
    private String religion;
    private String country;
    private String partnercast;
    private String gender;
    private Integer age;

    public PreferenceModel(Integer preference_id, String city, String religion, String country, String partnercast, String gender, Integer age) {
        this.preference_id = preference_id;
        this.city = city;
        this.religion = religion;
        this.country = country;
        this.partnercast = partnercast;
        this.gender = gender;
        this.age = age;
    }
    public PreferenceModel() {

    }

    public Integer getPreference_id() {
        return preference_id;
    }

    public void setPreference_id(Integer preference_id) {
        this.preference_id = preference_id;
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

    public String getPartnercast() {
        return partnercast;
    }

    public void setPartnercast(String partnercast) {
        this.partnercast = partnercast;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
