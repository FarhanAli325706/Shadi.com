package com.example.thymeleafapp;

import javax.persistence.*;

@Entity
@Table( name="contact")
public class ContactUsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer contactID;
    private String email;
    private String cname;
    private String cmessage;

    public ContactUsModel() {
    }

    public ContactUsModel(Integer contactID, String email, String cname, String cmessage) {
        this.contactID = contactID;
        this.email = email;
        this.cname = cname;
        this.cmessage = cmessage;
    }

    public Integer getContactID() {
        return contactID;
    }

    public void setContactID(Integer contactID) {
        this.contactID = contactID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getMessage() {
        return cmessage;
    }

    public void setMessage(String cmessage) {
        this.cmessage = cmessage;
    }
}
